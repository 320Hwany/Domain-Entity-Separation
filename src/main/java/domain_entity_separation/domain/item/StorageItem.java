package domain_entity_separation.domain.item;

public record StorageItem(
        Item item,
        long totalQuantity
) {
}
