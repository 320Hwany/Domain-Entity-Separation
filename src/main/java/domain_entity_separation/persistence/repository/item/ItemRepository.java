package domain_entity_separation.persistence.repository.item;

import domain_entity_separation.persistence.entity.item.ItemJpaEntity;

public interface ItemRepository {

    void save(final ItemJpaEntity itemJpaEntity);

    ItemJpaEntity getByIdWithPessimisticLock(final long itemId);

    long count();
}
