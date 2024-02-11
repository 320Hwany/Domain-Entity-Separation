package domain_entity_separation.persistence.repository.basket;

import domain_entity_separation.persistence.entity.basket.BasketJpaEntity;

public interface BasketRepository {

    void save(final BasketJpaEntity basketJpaEntity);
}
