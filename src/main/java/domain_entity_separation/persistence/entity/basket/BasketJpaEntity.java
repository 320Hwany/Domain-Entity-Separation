package domain_entity_separation.persistence.entity.basket;

import domain_entity_separation.global.annotation.Association;
import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "basket")
@Entity
public class BasketJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long id;

    @Association
    private Long itemId;

    private Long quantity;

    protected BasketJpaEntity() {
    }

    @Builder
    private BasketJpaEntity(final long itemId, final long quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
