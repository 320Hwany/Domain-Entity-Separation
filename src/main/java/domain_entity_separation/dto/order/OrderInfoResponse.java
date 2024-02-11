package domain_entity_separation.dto.order;

import com.querydsl.core.annotations.QueryProjection;
import domain_entity_separation.domain.order.OrderStatus;

import java.time.LocalDate;

public record OrderInfoResponse(
        String itemName,
        long itemPrice,
        long discountPrice,
        long totalQuantity,
        LocalDate discountDate,
        long itemQuantity,
        OrderStatus orderStatus
) {

    @QueryProjection
    public OrderInfoResponse {
    }
}
