package domain_entity_separation.presentation.item;

import domain_entity_separation.application.item.ItemService;
import domain_entity_separation.dto.item.ItemAddRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public void createItem(@RequestBody final ItemAddRequest itemAddRequest) {
        itemService.creatItem(itemAddRequest);
    }
}
