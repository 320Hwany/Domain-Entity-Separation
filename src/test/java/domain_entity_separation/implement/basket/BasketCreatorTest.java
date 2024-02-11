package domain_entity_separation.implement.basket;

import domain_entity_separation.dto.basket.BasketAddRequest;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class BasketCreatorTest extends ImplementTest {

    @Autowired
    private BasketCreator basketCreator;

    @DisplayName("회원이 특정 상품을 장바구니에 추가합니다.")
    @Test
    void addToBasket() {
        // given
        long memberId = 1L;
        BasketAddRequest basketAddRequest = BasketAddRequest.builder()
                .itemId(1L)
                .quantity(3)
                .build();

        // when
        basketCreator.addToBasket(memberId, basketAddRequest);

        // then
        assertThat(basketRepository.count()).isEqualTo(1);
    }
}