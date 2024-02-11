package domain_entity_separation.persistence.repository.order;

import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryImpl(final OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public void save(final OrderJpaEntity orderJpaEntity) {
        orderJpaRepository.save(orderJpaEntity);
    }

    @Override
    public long count() {
        return orderJpaRepository.count();
    }
}
