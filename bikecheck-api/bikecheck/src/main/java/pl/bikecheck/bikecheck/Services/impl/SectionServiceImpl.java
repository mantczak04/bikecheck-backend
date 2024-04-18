package pl.bikecheck.bikecheck.Services.impl;

import org.springframework.stereotype.Service;
import pl.bikecheck.bikecheck.Entities.Athlete;
import pl.bikecheck.bikecheck.Entities.Section;
import pl.bikecheck.bikecheck.Repositories.AthleteRepository;
import pl.bikecheck.bikecheck.Repositories.SectionRepository;
import pl.bikecheck.bikecheck.Services.SectionService;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final AthleteRepository athleteRepository;
    private final SectionRepository sectionRepository;

    public SectionServiceImpl(AthleteRepository athleteRepository, SectionRepository sectionRepository) {
        this.athleteRepository = athleteRepository;
        this.sectionRepository = sectionRepository;
    }


    @Override
    public Section createSectionByAthleteId(Section section, Long athleteId) {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(
                () -> new RuntimeException("Athlete with id " + athleteId + " not found."));
        section.setAthlete(athlete);
        athlete.getSections().add(section);
        athleteRepository.save(athlete);
        return section;
    }

    @Override
    public List<Section> getSectionByAthleteId(Long athleteId) {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(
                () -> new RuntimeException("Athlete with id " + athleteId + " not found."));
        List<Section> sections = athlete.getSections();
        return sections;
    }

    @Override
    public Section getSectionById(Long sectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(
                () -> new RuntimeException("Section with id " + sectionId + " not found."));
        return section;
    }

    @Override
    public List<Section> getAllSections() {
        List<Section> sections = sectionRepository.findAll();
        return sections;
    }
}
