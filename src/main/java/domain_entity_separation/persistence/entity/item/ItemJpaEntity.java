package domain_entity_separation.persistence.entity.item;

import domain_entity_separation.dto.item.ItemAddRequest;
import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Table(name = "item")
@Entity
public class ItemJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private Long itemPrice;

    private Long discountPrice;

    private Long totalQuantity;

    private LocalDate discountDate;

    protected ItemJpaEntity() {
    }

    @Builder
    private ItemJpaEntity(final String itemName, final Long itemPrice,
                          final Long discountPrice, final Long totalQuantity,
                          final LocalDate discountDate) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
        this.totalQuantity = totalQuantity;
        this.discountDate = discountDate;
    }

    public static ItemJpaEntity toEntity(final ItemAddRequest itemAddRequest) {
        return ItemJpaEntity.builder()
                .itemName(itemAddRequest.itemName())
                .itemPrice(itemAddRequest.itemPrice())
                .discountPrice(itemAddRequest.discountPrice())
                .totalQuantity(itemAddRequest.totalQuantity())
                .discountDate(itemAddRequest.discountDate())
                .build();
    }

    public void subtractTotalQuantity(final long itemQuantity) {
        this.totalQuantity -= itemQuantity;
    }
}