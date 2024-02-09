package domain_entity_separation.persistence.repository.order;

import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {
}
