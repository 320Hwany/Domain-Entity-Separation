package domain_entity_separation.persistence.repository.order;

import domain_entity_separation.dto.order.OrderInfoResponse;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;

import java.util.List;

public interface OrderRepository {

    void save(final OrderJpaEntity orderJpaEntity);

    OrderJpaEntity getById(final long orderId);

    long count();
}
