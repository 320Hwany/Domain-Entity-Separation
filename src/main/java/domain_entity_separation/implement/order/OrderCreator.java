package domain_entity_separation.implement.order;

import domain_entity_separation.domain.item.Item;
import domain_entity_separation.domain.order.Order;
import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.implement.item.ItemFinder;
import domain_entity_separation.implement.member.MemberFinder;
import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import domain_entity_separation.persistence.repository.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static domain_entity_separation.domain.order.OrderStatus.*;

@Implement
public class OrderCreator {

    private final OrderRepository orderRepository;
    private final OrderFinder orderFinder;
    private final ItemFinder itemFinder;
    private final MemberFinder memberFinder;

    public OrderCreator(final OrderRepository orderRepository,
                        final OrderFinder orderFinder,
                        final ItemFinder itemFinder,
                        final MemberFinder memberFinder) {
        this.orderRepository = orderRepository;
        this.orderFinder = orderFinder;
        this.itemFinder = itemFinder;
        this.memberFinder = memberFinder;
    }

    @Transactional
    public void addToBasket(final long memberId, final AddToBasketRequest addToBasketRequest) {
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.addToBasketEntity(memberId, addToBasketRequest);
        orderRepository.save(orderJpaEntity);
    }

    @Transactional
    public void completeOrder(final long memberId, final long orderId) {
        MemberJpaEntity memberJpaEntity = memberFinder.getByIdWithPessimisticLock(memberId);
        OrderJpaEntity orderJpaEntity = updateOrderStatus(orderId);
        ItemJpaEntity itemJpaEntity = itemFinder.getByIdWithPessimisticLock(orderJpaEntity.getItemId());

        Order order = toDomain(itemJpaEntity, orderJpaEntity);
        calculatePrice(order, memberJpaEntity, itemJpaEntity);
    }

    private OrderJpaEntity updateOrderStatus(final long orderId) {
        OrderJpaEntity orderJpaEntity = orderFinder.getById(orderId);
        orderJpaEntity.updateOrderStatus(ORDER_COMPLETE);
        return orderJpaEntity;
    }

    private Order toDomain(final ItemJpaEntity itemJpaEntity, final OrderJpaEntity orderJpaEntity) {
        Item item = Item.toDomain(itemJpaEntity);
        return Order.toDomain(item, orderJpaEntity);
    }

    private void calculatePrice(final Order order, final MemberJpaEntity memberJpaEntity,
                                final ItemJpaEntity itemJpaEntity) {
        long orderPrice = order.calculatePrice(memberJpaEntity.getMoney(), LocalDate.now());

        memberJpaEntity.subtractOrderPrice(orderPrice);
        itemJpaEntity.subtractTotalQuantity(order.itemQuantity());
    }
}
