package domain_entity_separation.domain.basket;

import domain_entity_separation.domain.item.Item;


public record Basket(
        Item item,
        long quantity
) {
}
