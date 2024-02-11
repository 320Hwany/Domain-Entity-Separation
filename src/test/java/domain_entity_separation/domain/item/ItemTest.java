package domain_entity_separation.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class ItemTest {

    @DisplayName("현재 날짜가 할인 기간을 지나면 원래 상품 가격으로 계산합니다.")
    @Test
    void notApplyDiscount() {
        // given
        LocalDate discountDate = LocalDate.of(2024, 02, 01);
        LocalDate nowDate = LocalDate.of(2024, 03, 01);

        Item item = Item.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .discountDate(discountDate)
                .build();

        // when
        long itemPrice = item.applyDiscount(nowDate);

        // then
        assertThat(itemPrice).isEqualTo(10000);
    }

    @DisplayName("현재 날짜가 할인 기간을 지나지 않았으면 할인 가격으로 계산합니다.")
    @Test
    void applyDiscount() {
        // given
        LocalDate discountDate = LocalDate.of(2024, 02, 01);
        LocalDate nowDate = LocalDate.of(2024, 01, 01);

        Item item = Item.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .discountDate(discountDate)
                .build();

        // when
        long itemPrice = item.applyDiscount(nowDate);

        // then
        assertThat(itemPrice).isEqualTo(8000);
    }
}