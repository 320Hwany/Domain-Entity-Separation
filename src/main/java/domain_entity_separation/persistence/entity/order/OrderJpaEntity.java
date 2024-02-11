package domain_entity_separation.persistence.entity.order;

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
    private Long basketId;

    private Long orderPrice;

    protected OrderJpaEntity() {
    }

    @Builder
    private OrderJpaEntity(final Long basketId, final Long orderPrice) {
        this.basketId = basketId;
        this.orderPrice = orderPrice;
    }
}
