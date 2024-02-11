package domain_entity_separation.implement.item;

import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import domain_entity_separation.persistence.repository.item.ItemRepository;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class ItemFinder {

    private final ItemRepository itemRepository;

    public ItemFinder(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = true)
    public ItemJpaEntity getByIdWithPessimisticLock(final long itemId) {
        return itemRepository.getByIdWithPessimisticLock(itemId);
    }
}
