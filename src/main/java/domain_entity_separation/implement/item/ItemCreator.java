package domain_entity_separation.implement.item;

import domain_entity_separation.dto.item.ItemAddRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import domain_entity_separation.persistence.repository.item.ItemRepository;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class ItemCreator {

    private final ItemRepository itemRepository;

    public ItemCreator(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void creatItem(final ItemAddRequest itemAddRequest) {
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.toEntity(itemAddRequest);
        itemRepository.save(itemJpaEntity);
    }
}
