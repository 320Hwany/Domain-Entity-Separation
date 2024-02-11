package domain_entity_separation.persistence.entity.order;

import domain_entity_separation.domain.order.OrderStatus;
import domain_entity_separation.dto.order.AddToBasketRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OrderJpaEntityTest {

    @DisplayName("장바구니에 추가하기 위한 DB 엔티티를 생성한다.")
    @Test
    void addToBasketEntity() {
        // given
        long memberId = 1L;
        AddToBasketRequest addToBasketRequest = AddToBasketRequest.builder()
                .itemId(1L)
                .itemQuantity(1000)
                .build();

        // when
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.addToBasketEntity(memberId, addToBasketRequest);

        // then
        assertThat(orderJpaEntity.getOrderStatus()).isEqualTo(OrderStatus.BASKET);
    }
}