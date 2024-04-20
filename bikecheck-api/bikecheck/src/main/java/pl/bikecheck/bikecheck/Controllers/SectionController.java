package pl.bikecheck.bikecheck.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bikecheck.bikecheck.Entities.Item;
import pl.bikecheck.bikecheck.Entities.Section;
import pl.bikecheck.bikecheck.Services.ItemService;
import pl.bikecheck.bikecheck.Services.SectionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sections")
@CrossOrigin
public class SectionController {

    private final SectionService sectionService;
    private final ItemService itemService;

    public SectionController(SectionService sectionService, ItemService itemService) {
        this.sectionService = sectionService;
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections(){
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    @GetMapping("/{sectionId}")
    public ResponseEntity<Section> getSectionById(@PathVariable("sectionId") Long sectionId){
        return ResponseEntity.ok(sectionService.getSectionById(sectionId));
    }

    @PostMapping("/{sectionId}/items")
    public ResponseEntity<Item> createItemBySectionId(
            @PathVariable("sectionId") Long sectionId,
            @RequestBody Item item){
        return new ResponseEntity<Item>(itemService.createItemBySectionId(sectionId, item), HttpStatus.CREATED);
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<String> deleteSectionById(@PathVariable("sectionId") Long sectionId){
        sectionService.deleteSectionById(sectionId);
        return new ResponseEntity<>("Section deleted successfully", HttpStatus.OK);
    }
}
