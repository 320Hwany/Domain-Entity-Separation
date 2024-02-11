package domain_entity_separation.presentation.basket;

import domain_entity_separation.application.basket.BasketService;
import domain_entity_separation.domain.member.MemberSession;
import domain_entity_separation.dto.basket.BasketAddRequest;
import domain_entity_separation.global.annotation.Login;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class BasketController {

    private final BasketService basketService;

    public BasketController(final BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/baskets")
    public void basket(@Login final MemberSession memberSession,
                       @RequestBody final BasketAddRequest basketAddRequest) {
        basketService.addToBasket(memberSession.memberId(), basketAddRequest);
    }
}
