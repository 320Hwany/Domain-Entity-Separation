package domain_entity_separation.dto.item;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ItemAddRequest(
        String itemName,
        long itemPrice,
        long discountPrice,
        long totalQuantity,
        LocalDate discountDate
) {
}
