package domain_entity_separation.application.item;

import domain_entity_separation.dto.item.ItemAddRequest;
import domain_entity_separation.implement.item.ItemCreator;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemCreator itemCreator;

    public ItemService(final ItemCreator itemCreator) {
        this.itemCreator = itemCreator;
    }

    public void creatItem(final ItemAddRequest itemAddRequest) {
        itemCreator.creatItem(itemAddRequest);
    }
}
