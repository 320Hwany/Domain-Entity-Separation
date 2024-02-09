package domain_entity_separation.domain.item;

public record StorageItem(
        long totalQuantity
) {

    public long calculateQuantity(final long itemQuantity) {
        long remainQuantity = totalQuantity - itemQuantity;
        validateQuantity(remainQuantity);

        return remainQuantity;
    }

    private void validateQuantity(final long remainQuantity) {
        if (remainQuantity < 0) {
            throw new IllegalArgumentException("재고 수량이 부족합니다");
        }
    }
}
