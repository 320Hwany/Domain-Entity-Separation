package domain_entity_separation.persistence.repository.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(final OrderJpaRepository orderJpaRepository,
                               final JPAQueryFactory queryFactory) {
        this.orderJpaRepository = orderJpaRepository;
        this.queryFactory = queryFactory;
    }

    @Override
    public void save(final OrderJpaEntity orderJpaEntity) {
        orderJpaRepository.save(orderJpaEntity);
    }

    @Override
    public OrderJpaEntity getById(final long orderId) {
        return orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("주문 정보를 찾을 수 없습니다."));
    }

    @Override
    public long count() {
        return orderJpaRepository.count();
    }
}
