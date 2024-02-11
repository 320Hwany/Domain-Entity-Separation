package domain_entity_separation.domain.order;


import domain_entity_separation.domain.item.Item;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Order(
        Item item,
        long itemQuantity,
        OrderStatus orderStatus
) {

    public static Order toDomain(final Item item, final OrderJpaEntity orderJpaEntity) {
        return Order.builder()
                .item(item)
                .itemQuantity(orderJpaEntity.getItemQuantity())
                .orderStatus(orderJpaEntity.getOrderStatus())
                .build();
    }

    public long calculatePrice(final long money, final LocalDate now) {
        validateQuantity();
        long itemPrice = item.applyDiscount(now);
        long orderPrice = itemPrice * itemQuantity;
        validateMoney(money, orderPrice);

        return orderPrice;
    }

    private void validateQuantity() {
        if (item.totalQuantity() < itemQuantity) {
            throw new IllegalStateException("재고 수량이 부족합니다.");
        }
    }

    private void validateMoney(final long money, final long totalPrice) {
        if (money < totalPrice) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }
}
