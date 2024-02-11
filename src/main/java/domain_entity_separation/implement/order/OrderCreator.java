package domain_entity_separation.implement.order;

import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import domain_entity_separation.persistence.repository.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class OrderCreator {

    private final OrderRepository orderRepository;

    public OrderCreator(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void addToBasket(final long memberId, final AddToBasketRequest addToBasketRequest) {
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.addToBasketEntity(memberId, addToBasketRequest);
        orderRepository.save(orderJpaEntity);
    }
}
