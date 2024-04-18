package pl.bikecheck.bikecheck.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bikecheck.bikecheck.Entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
