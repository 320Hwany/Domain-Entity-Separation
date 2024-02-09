package domain_entity_separation.domain.basket;

import domain_entity_separation.domain.item.Item;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Basket(
        Item item,
        long quantity
) {

    public long calculatePrice(final LocalDate now) {
        long itemPrice = item.applyDiscount(now);
        return itemPrice * quantity;
    }
}
