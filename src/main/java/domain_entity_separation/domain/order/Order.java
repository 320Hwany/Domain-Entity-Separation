package domain_entity_separation.domain.order;

import domain_entity_separation.domain.basket.Basket;

import java.util.List;

public record Order(
        List<Basket> baskets
) {
}
