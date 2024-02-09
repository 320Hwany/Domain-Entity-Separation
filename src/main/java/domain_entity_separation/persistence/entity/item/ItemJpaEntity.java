package domain_entity_separation.persistence.entity.item;

import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class ItemJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private long itemPrice;

    private long discountPrice;

    private LocalDate discountDate;

    protected ItemJpaEntity() {
    }

    @Builder
    private ItemJpaEntity(final String itemName, final long itemPrice,
                         final long discountPrice, final LocalDate discountDate) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
        this.discountDate = discountDate;
    }
}