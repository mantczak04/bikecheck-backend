package pl.bikecheck.bikecheck.Services;

import pl.bikecheck.bikecheck.Entities.Item;

import java.util.List;

public interface ItemService {
    Item createItemBySectionId(Long sectionId, Item item);

    List<Item> getAllItems();
}
