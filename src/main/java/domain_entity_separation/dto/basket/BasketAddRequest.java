package domain_entity_separation.dto.basket;

public record BasketAddRequest(
        long itemId,
        long quantity
) {
}
