package domain_entity_separation.persistence.repository.storage_item;

import domain_entity_separation.persistence.entity.storage_item.StorageItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageItemJpaRepository extends JpaRepository<StorageItemJpaEntity, Long> {
}
