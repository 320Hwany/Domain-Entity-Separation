package domain_entity_separation.persistence.repository.basket;

import org.springframework.stereotype.Repository;

@Repository
public class BasketRepositoryImpl implements BasketRepository {

    private final BasketJpaRepository basketJpaRepository;

    public BasketRepositoryImpl(final BasketJpaRepository basketJpaRepository) {
        this.basketJpaRepository = basketJpaRepository;
    }
}
