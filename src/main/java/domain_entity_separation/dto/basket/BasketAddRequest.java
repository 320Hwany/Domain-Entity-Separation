package domain_entity_separation.dto.basket;

import lombok.Builder;

@Builder
public record BasketAddRequest(
        long itemId,
        long quantity
) {
}
