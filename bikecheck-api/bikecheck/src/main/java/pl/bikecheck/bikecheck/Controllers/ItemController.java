package pl.bikecheck.bikecheck.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bikecheck.bikecheck.Entities.Item;
import pl.bikecheck.bikecheck.Services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }
}
