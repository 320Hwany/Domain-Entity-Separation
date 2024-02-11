package domain_entity_separation.implement.order;

import domain_entity_separation.domain.order.OrderStatus;
import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

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

    @DisplayName("상품 주문을 완료하면 주문 상태가 ORDER_COMPLETE로 수정됩니다.")
    @Test
    void updateOrderStatus() {
        // given - 회원
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .money(100000)
                .build();

        memberRepository.save(memberJpaEntity);

        // given - 상품
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(10)
                .discountDate(LocalDate.of(2024, 02, 01))
                .build();

        itemRepository.save(itemJpaEntity);

        // given - 주문
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberId(memberJpaEntity.getId())
                .itemId(itemJpaEntity.getId())
                .itemQuantity(5)
                .build();

        orderRepository.save(orderJpaEntity);

        // when
        orderCreator.createOrder(memberJpaEntity.getId(), orderJpaEntity.getId());

        // then
        OrderJpaEntity findOrderEntity = orderRepository.getById(orderJpaEntity.getId());
        assertThat(findOrderEntity.getOrderStatus()).isEqualTo(OrderStatus.ORDER_COMPLETE);
    }

    @DisplayName("상품 주문을 완료하면 회원이 가진 돈이 주문 가격만큼 차감됩니다.")
    @Test
    void subtractOrderPrice() {
        // given - 회원
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .money(100000)
                .build();

        memberRepository.save(memberJpaEntity);

        // given - 상품
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(10)
                .discountDate(LocalDate.of(2024, 02, 01))
                .build();

        itemRepository.save(itemJpaEntity);

        // given - 주문
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberId(memberJpaEntity.getId())
                .itemId(itemJpaEntity.getId())
                .itemQuantity(5)
                .build();

        orderRepository.save(orderJpaEntity);

        // when
        orderCreator.createOrder(memberJpaEntity.getId(), orderJpaEntity.getId());

        // then
        MemberJpaEntity findMemberEntity = memberRepository.getById(memberJpaEntity.getId());
        assertThat(findMemberEntity.getMoney()).isEqualTo(50000);
    }

    @DisplayName("상품 주문을 완료하면 주문 수량만큼 상품 재고에서 차감됩니다.")
    @Test
    void subtractTotalQuantity() {
        // given - 회원
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .money(100000)
                .build();

        memberRepository.save(memberJpaEntity);

        // given - 상품
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .itemPrice(10000)
                .discountPrice(2000)
                .totalQuantity(10)
                .discountDate(LocalDate.of(2024, 02, 01))
                .build();

        itemRepository.save(itemJpaEntity);

        // given - 주문
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberId(memberJpaEntity.getId())
                .itemId(itemJpaEntity.getId())
                .itemQuantity(5)
                .build();

        orderRepository.save(orderJpaEntity);

        // when
        orderCreator.createOrder(memberJpaEntity.getId(), orderJpaEntity.getId());

        // then
        ItemJpaEntity findItemEntity = itemRepository.getById(itemJpaEntity.getId());
        assertThat(findItemEntity.getTotalQuantity()).isEqualTo(5);
    }
}