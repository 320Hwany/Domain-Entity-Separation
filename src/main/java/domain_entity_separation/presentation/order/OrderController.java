package domain_entity_separation.presentation.order;

import domain_entity_separation.application.order.OrderService;
import domain_entity_separation.domain.member.MemberSession;
import domain_entity_separation.dto.order.AddToBasketRequest;
import domain_entity_separation.global.annotation.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public void addToBasket(@Login final MemberSession memberSession,
                            @RequestBody final AddToBasketRequest addToBasketRequest) {
        orderService.addToBasket(memberSession.memberId(), addToBasketRequest);
    }
}
