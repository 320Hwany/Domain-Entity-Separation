package domain_entity_separation.domain.item;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public record Item(
        String itemName,
        long price,
        LocalDate discountDate
) {
}
