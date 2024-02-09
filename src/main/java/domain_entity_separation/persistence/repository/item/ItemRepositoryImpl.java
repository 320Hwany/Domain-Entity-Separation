package domain_entity_separation.persistence.repository.item;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryImpl(final ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }
}
