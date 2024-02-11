package domain_entity_separation.application.basket;

import domain_entity_separation.dto.basket.BasketAddRequest;
import domain_entity_separation.implement.basket.BasketCreator;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final BasketCreator basketCreator;

    public BasketService(final BasketCreator basketCreator) {
        this.basketCreator = basketCreator;
    }

    public void addToBasket(final long memberId, final BasketAddRequest basketAddRequest) {
        basketCreator.addToBasket(memberId, basketAddRequest);
    }
}
