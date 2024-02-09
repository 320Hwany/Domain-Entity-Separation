package domain_entity_separation.persistence.repository.storage_item;

import org.springframework.stereotype.Repository;

@Repository
public class StorageItemRepositoryImpl implements StorageItemRepository {

    private final StorageItemJpaRepository storageItemJpaRepository;

    public StorageItemRepositoryImpl(final StorageItemJpaRepository storageItemJpaRepository) {
        this.storageItemJpaRepository = storageItemJpaRepository;
    }
}
