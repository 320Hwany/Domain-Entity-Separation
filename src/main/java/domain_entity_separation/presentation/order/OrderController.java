package domain_entity_separation.presentation.order;

import domain_entity_separation.application.order.OrderService;
import domain_entity_separation.domain.member.MemberSession;
import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.global.annotation.Login;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders-basket")
    public void addToBasket(@Login final MemberSession memberSession,
                            @RequestBody final AddToBasketRequest addToBasketRequest) {
        orderService.addToBasket(memberSession.memberId(), addToBasketRequest);
    }

    @PostMapping("/orders/{orderId}")
    public void createOrder(@Login final MemberSession memberSession, @PathVariable final long orderId) {
        orderService.createOrder(memberSession.memberId(), orderId);
    }
}
