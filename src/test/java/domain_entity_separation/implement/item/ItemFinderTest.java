package domain_entity_separation.implement.item;

import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;


class ItemFinderTest extends ImplementTest {

    @Autowired
    private ItemFinder itemFinder;

    @DisplayName("상품 id로 상품 정보를 가져옵니다.")
    @Test
    void getByIdWithPessimisticLock() {
        // given
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .itemPrice(10000L)
                .build();

        itemRepository.save(itemJpaEntity);

        // when
        ItemJpaEntity findEntity = itemFinder.getByIdWithPessimisticLock(itemJpaEntity.getId());

        // then
        assertThat(findEntity).isNotNull();
    }
}