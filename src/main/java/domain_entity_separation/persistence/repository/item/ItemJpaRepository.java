package domain_entity_separation.persistence.repository.item;

import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemJpaEntity, Long> {
}
