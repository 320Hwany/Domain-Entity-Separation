package domain_entity_separation.domain.order;

import domain_entity_separation.domain.member.Member;

import java.time.LocalDate;
import java.util.List;

public record Order(
        Member member
//        List<Basket> baskets
) {

//    public long progressPayment(final LocalDate now) {
//        List<Basket> baskets = baskets();
//        long totalPrice = baskets.stream()
//                .mapToLong(basket -> basket.calculatePrice(now))
//                .sum();
//
//        validateMoney(totalPrice);
//        return member.money() - totalPrice;
//    }
//
//    private void validateMoney(final long totalPrice) {
//        if (member.money() < totalPrice) {
//            throw new IllegalArgumentException("금액이 부족합니다.");
//        }
//    }
}
