package domain_entity_separation.domain.item;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public record Item(
        String itemName,
        long itemPrice,
        long discountPrice,
        LocalDate discountDate
) {

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
