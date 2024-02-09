package domain_entity_separation.persistence.repository.basket;

import domain_entity_separation.persistence.entity.basket.BasketJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketJpaRepository extends JpaRepository<BasketJpaEntity, Long> {
}
