package domain_entity_separation.persistence.repository.item;

import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryImpl(final ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public void save(final ItemJpaEntity itemJpaEntity) {
        itemJpaRepository.save(itemJpaEntity);
    }

    @Override
    public long count() {
        return itemJpaRepository.count();
    }
}
