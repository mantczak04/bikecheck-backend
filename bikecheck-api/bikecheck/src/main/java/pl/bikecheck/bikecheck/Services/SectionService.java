package pl.bikecheck.bikecheck.Services;

import pl.bikecheck.bikecheck.Entities.Section;

import java.util.List;

public interface SectionService {
    Section createSectionByAthleteId(Section section, Long athleteId);

    List<Section> getSectionByAthleteId(Long athleteId);

    Section getSectionById(Long sectionId);

    List<Section> getAllSections();
}
