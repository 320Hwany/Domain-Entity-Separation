package domain_entity_separation.persistence.entity.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemJpaEntityTest {

    @DisplayName("주문 수량만큼 재고에서 차감합니다.")
    @Test
    void subtractTotalQuantity() {
        // given
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .totalQuantity(10)
                .build();

        // when
        itemJpaEntity.subtractTotalQuantity(5);

        // then
        assertThat(itemJpaEntity.getTotalQuantity()).isEqualTo(5);
    }
}