package pl.bikecheck.bikecheck.Services.impl;

import org.springframework.stereotype.Service;
import pl.bikecheck.bikecheck.Entities.Item;
import pl.bikecheck.bikecheck.Entities.Section;
import pl.bikecheck.bikecheck.Repositories.ItemRepository;
import pl.bikecheck.bikecheck.Repositories.SectionRepository;
import pl.bikecheck.bikecheck.Services.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final SectionRepository sectionRepository;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(SectionRepository sectionRepository, ItemRepository itemRepository) {
        this.sectionRepository = sectionRepository;
        this.itemRepository = itemRepository;
    }


    @Override
    public Item createItemBySectionId(Long sectionId, Item item) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(
                () -> new RuntimeException("Section with id " + sectionId + " not found."));
        item.setSection(section);
        section.getItems().add(item);
        sectionRepository.save(section);
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItemById(Long id, Item item) {
        Item updateItem = itemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Item with id " + id + " not found."));

        updateItem.setPart(item.getPart());
        updateItem.setName(item.getName());
        updateItem.setImageUrl(item.getImageUrl());
        updateItem.setAmazonUrl("https://www.amazon.com/s?k="+item.getName().replace(" ", "+"));
        return itemRepository.save(updateItem);
    }
}
