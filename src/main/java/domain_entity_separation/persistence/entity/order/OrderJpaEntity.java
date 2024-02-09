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
    private Long memberId;

    @Association
    private Long basketId;

    protected OrderJpaEntity() {
    }

    @Builder
    private OrderJpaEntity(final long memberId, final long basketId) {
        this.memberId = memberId;
        this.basketId = basketId;
    }
}
