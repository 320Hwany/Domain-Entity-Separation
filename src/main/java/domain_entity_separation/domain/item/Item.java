package domain_entity_separation.domain.item;

import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import lombok.Builder;

import java.time.LocalDate;


@Builder
public record Item(
        String itemName,
        long itemPrice,
        long discountPrice,
        long totalQuantity,
        LocalDate discountDate
) {

    public static Item toDomain(final ItemJpaEntity itemJpaEntity) {
        return Item.builder()
                .itemName(itemJpaEntity.getItemName())
                .itemPrice(itemJpaEntity.getItemPrice())
                .discountPrice(itemJpaEntity.getDiscountPrice())
                .totalQuantity(itemJpaEntity.getTotalQuantity())
                .discountDate(itemJpaEntity.getDiscountDate())
                .build();
    }

    public long applyDiscount(final LocalDate now) {
        if (isDiscount(now)) {
            return itemPrice - discountPrice;
        }

        return itemPrice;
    }

    private boolean isDiscount(final LocalDate now) {
        return discountDate.isAfter(now);
    }
}
