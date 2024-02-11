package domain_entity_separation.dto.item;

import java.time.LocalDate;

public record ItemAddRequest(
        String itemName,
        long itemPrice,
        long discountPrice,
        long totalQuantity,
        LocalDate discountDate
) {
}
