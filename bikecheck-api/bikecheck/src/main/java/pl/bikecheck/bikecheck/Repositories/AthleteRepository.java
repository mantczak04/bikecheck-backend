package pl.bikecheck.bikecheck.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bikecheck.bikecheck.Entities.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
