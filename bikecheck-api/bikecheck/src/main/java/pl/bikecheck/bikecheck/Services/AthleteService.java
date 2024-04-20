package pl.bikecheck.bikecheck.Services;

import pl.bikecheck.bikecheck.Entities.Athlete;

import java.util.List;

public interface AthleteService {
    List<Athlete> getAllAthletes();

    Athlete createAthlete(Athlete athlete);

    Athlete getAthleteById(Long id);

    Athlete updateAthleteById(Long id, Athlete athlete);

    void deleteAthleteById(Long id);
}
