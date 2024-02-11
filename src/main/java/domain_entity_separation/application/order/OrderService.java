package domain_entity_separation.application.order;

import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.implement.order.OrderCreator;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderCreator orderCreator;

    public OrderService(final OrderCreator orderCreator) {
        this.orderCreator = orderCreator;
    }

    public void addToBasket(final long memberId, final AddToBasketRequest addToBasketRequest) {
        orderCreator.addToBasket(memberId, addToBasketRequest);
    }

    public void createOrder(final long memberId, final long orderId) {
        orderCreator.createOrder(memberId, orderId);
    }
}
