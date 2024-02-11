package domain_entity_separation.persistence.entity.basket;

import domain_entity_separation.domain.basket.BasketStatus;
import domain_entity_separation.dto.basket.BasketAddRequest;
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
    private Long memberId;

    @Association
    private Long itemId;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private BasketStatus basketStatus;

    protected BasketJpaEntity() {
    }

    @Builder
    private BasketJpaEntity(final Long memberId, final Long itemId,
                            final Long quantity, final BasketStatus basketStatus) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.basketStatus = basketStatus;
    }

    public static BasketJpaEntity createForAddition(final long memberId, final BasketAddRequest basketAddRequest) {
        return BasketJpaEntity.builder()
                .memberId(memberId)
                .itemId(basketAddRequest.itemId())
                .quantity(basketAddRequest.quantity())
                .basketStatus(BasketStatus.BASKET)
                .build();
    }
}
