package domain_entity_separation.persistence.entity.order;

import domain_entity_separation.domain.order.OrderStatus;
import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.global.annotation.Association;
import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "orders")
@Entity
public class OrderJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Association
    private Long memberId;

    @Association
    private Long itemId;

    private Long itemQuantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    protected OrderJpaEntity() {
    }

    @Builder
    private OrderJpaEntity(final long memberId, final long itemId,
                           final long itemQuantity, final OrderStatus orderStatus) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.orderStatus = orderStatus;
    }

    public static OrderJpaEntity addToBasketEntity(final long memberId, final AddToBasketRequest addToBasketRequest) {
        return OrderJpaEntity.builder()
                .memberId(memberId)
                .itemId(addToBasketRequest.itemId())
                .itemQuantity(addToBasketRequest.itemQuantity())
                .orderStatus(OrderStatus.BASKET)
                .build();
    }

    public void updateOrderStatus(final OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
