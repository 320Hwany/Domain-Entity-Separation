package domain_entity_separation.dto.order;


import lombok.Builder;

@Builder
public record AddToBasketRequest(
         long itemId,
         long itemQuantity
) {
}
