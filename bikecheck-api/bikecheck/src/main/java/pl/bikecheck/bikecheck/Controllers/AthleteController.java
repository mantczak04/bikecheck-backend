package pl.bikecheck.bikecheck.Controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bikecheck.bikecheck.Entities.Athlete;
import pl.bikecheck.bikecheck.Entities.Item;
import pl.bikecheck.bikecheck.Entities.Section;
import pl.bikecheck.bikecheck.Services.AthleteService;
import pl.bikecheck.bikecheck.Services.SectionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/athlete")
@CrossOrigin
public class AthleteController {

    private final AthleteService athleteService;
    private final SectionService sectionService;

    public AthleteController(AthleteService athleteService, SectionService sectionService) {
        this.athleteService = athleteService;
        this.sectionService = sectionService;
    }


    @GetMapping
    public ResponseEntity<List<Athlete>> getAllAthletes(){
        return ResponseEntity.ok(athleteService.getAllAthletes());
    }

    @PostMapping
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete){
        return ResponseEntity.ok(athleteService.createAthlete(athlete));
    }

    @PutMapping("/{athleteId}")
    public ResponseEntity<Athlete> updateAthleteById(@PathVariable Long athleteId,
                                                     @RequestBody Athlete athlete){
        return ResponseEntity.ok(athleteService.updateAthleteById(athleteId, athlete));
    }


    @GetMapping("/{athleteId}")
    @CrossOrigin
    public ResponseEntity<Athlete> getAthleteById(@PathVariable("athleteId") Long athleteId){
        return ResponseEntity.ok(athleteService.getAthleteById(athleteId));
    }

    @PostMapping("/{athleteId}/sections")
    @CrossOrigin
    public ResponseEntity<Section> createSectionByAthleteId(
            @PathVariable("athleteId") Long athleteId,
            @RequestBody Section section){
        return new ResponseEntity<>(sectionService.createSectionByAthleteId(section, athleteId), HttpStatus.CREATED);
    }

    @GetMapping("/{athleteId}/sections")
    public ResponseEntity<List<Section>> getSectionByAthleteId(@PathVariable("athleteId") Long athleteId){
        return ResponseEntity.ok(sectionService.getSectionByAthleteId(athleteId));
    }

}
