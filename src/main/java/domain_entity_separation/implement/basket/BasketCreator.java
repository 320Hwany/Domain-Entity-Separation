package domain_entity_separation.implement.basket;

import domain_entity_separation.dto.basket.BasketAddRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.basket.BasketJpaEntity;
import domain_entity_separation.persistence.repository.basket.BasketRepository;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class BasketCreator {

    private final BasketRepository basketRepository;

    public BasketCreator(final BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Transactional
    public void addToBasket(final long memberId, final BasketAddRequest basketAddRequest) {
        BasketJpaEntity basketJpaEntity = BasketJpaEntity.createForAddition(memberId, basketAddRequest);
        basketRepository.save(basketJpaEntity);
    }
}
