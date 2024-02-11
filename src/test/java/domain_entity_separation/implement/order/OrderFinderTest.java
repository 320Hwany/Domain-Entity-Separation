package domain_entity_separation.implement.order;

import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class OrderFinderTest extends ImplementTest {

    @Autowired
    private OrderFinder orderFinder;

    @DisplayName("주문 id로 주문 정보를 가져옵니다.")
    @Test
    void getById() {
        // given
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .itemQuantity(10000L)
                .build();

        orderRepository.save(orderJpaEntity);

        // when
        OrderJpaEntity findEntity = orderFinder.getById(orderJpaEntity.getId());

        // then
        assertThat(findEntity).isNotNull();
    }
}