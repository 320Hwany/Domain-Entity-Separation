package domain_entity_separation.implement.order;

import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;


class OrderCreatorTest extends ImplementTest {

    @Autowired
    private OrderCreator orderCreator;

    @DisplayName("회원이 상품을 장바구니에 추가합니다.")
    @Test
    void addToBasket() {
        // given
        long memberId = 1L;
        AddToBasketRequest addToBasketRequest = AddToBasketRequest.builder()
                .itemId(1L)
                .itemQuantity(1000)
                .build();

        // when
        orderCreator.addToBasket(memberId, addToBasketRequest);

        // then
        assertThat(orderRepository.count()).isEqualTo(1);
    }
}