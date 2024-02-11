package domain_entity_separation.implement.item;

import domain_entity_separation.dto.item.ItemAddRequest;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ItemCreatorTest extends ImplementTest {

    @Autowired
    private ItemCreator itemCreator;

    @DisplayName("상품 정보를 생성한다.")
    @Test
    void creatItem() {
        // given
        ItemAddRequest itemAddRequest = ItemAddRequest.builder()
                .itemName("상품명")
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(3000)
                .discountDate(LocalDate.of(2024, 03, 01))
                .build();

        // when
        itemCreator.creatItem(itemAddRequest);

        // then
        assertThat(itemRepository.count()).isEqualTo(1);
    }
}