package domain_entity_separation.implement.order;

import domain_entity_separation.persistence.entity.order.OrderJpaEntity;
import domain_entity_separation.persistence.repository.order.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderFinder {

    private final OrderRepository orderRepository;

    public OrderFinder(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public OrderJpaEntity getById(final long orderId) {
        return orderRepository.getById(orderId);
    }
}
