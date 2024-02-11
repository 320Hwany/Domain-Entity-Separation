package domain_entity_separation.domain.order;

import domain_entity_separation.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @DisplayName("상품 재고가 부족하면 예외가 발생합니다.")
    @Test
    void notEnoughQuantity() {
        // given
        LocalDate discountDate = LocalDate.of(2024, 02, 01);
        LocalDate nowDate = LocalDate.of(2024, 03, 01);

        Item item = Item.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(5)
                .discountDate(discountDate)
                .build();

        Order order = Order.builder()
                .item(item)
                .itemQuantity(6)
                .orderStatus(OrderStatus.BASKET)
                .build();

        // expected
        assertThatThrownBy(() -> order.calculatePrice(10000 * 6, nowDate))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("재고 수량이 부족합니다.");
    }

    @DisplayName("금액이 부족하면 예외가 발생합니다.")
    @Test
    void notEnoughMoney() {
        // given
        LocalDate discountDate = LocalDate.of(2024, 02, 01);
        LocalDate nowDate = LocalDate.of(2024, 03, 01);

        Item item = Item.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(6)
                .discountDate(discountDate)
                .build();

        Order order = Order.builder()
                .item(item)
                .itemQuantity(6)
                .orderStatus(OrderStatus.BASKET)
                .build();

        // expected
        assertThatThrownBy(() -> order.calculatePrice(10000 * 6 - 1, nowDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액이 부족합니다.");
    }

    @DisplayName("상품을 주문하면 주문 가격을 계산하고 반환합니다.")
    @Test
    void calculatePrice() {
        // given
        LocalDate discountDate = LocalDate.of(2024, 02, 01);
        LocalDate nowDate = LocalDate.of(2024, 03, 01);

        Item item = Item.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(5)
                .discountDate(discountDate)
                .build();

        Order order = Order.builder()
                .item(item)
                .itemQuantity(5)
                .orderStatus(OrderStatus.BASKET)
                .build();

        // when
        long orderPrice = order.calculatePrice(10000 * 6, nowDate);

        // then
        assertThat(orderPrice).isEqualTo(50000);
    }
}