package domain_entity_separation.persistence.repository.basket;

import domain_entity_separation.persistence.entity.basket.BasketJpaEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BasketRepositoryImpl implements BasketRepository {

    private final BasketJpaRepository basketJpaRepository;

    public BasketRepositoryImpl(final BasketJpaRepository basketJpaRepository) {
        this.basketJpaRepository = basketJpaRepository;
    }

    @Override
    public void save(final BasketJpaEntity basketJpaEntity) {
        basketJpaRepository.save(basketJpaEntity);
    }
}
