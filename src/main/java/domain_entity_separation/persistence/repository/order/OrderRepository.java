package domain_entity_separation.persistence.repository.order;

import domain_entity_separation.persistence.entity.order.OrderJpaEntity;

public interface OrderRepository {

    void save(final OrderJpaEntity orderJpaEntity);

    long count();
}
