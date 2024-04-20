package pl.bikecheck.bikecheck.Services.impl;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import pl.bikecheck.bikecheck.Entities.Athlete;
import pl.bikecheck.bikecheck.Entities.Section;
import pl.bikecheck.bikecheck.Repositories.AthleteRepository;
import pl.bikecheck.bikecheck.Services.AthleteService;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {
    private final AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }


    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    @Override
    public Athlete createAthlete(Athlete athlete) {
        Athlete newAthlete = athleteRepository.save(athlete);
        return newAthlete;
    }

    @Override
    public Athlete getAthleteById(Long id) {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new RuntimeException("Athlete with this id not found"));
        return athlete;
    }

    @Override
    public Athlete updateAthleteById(Long id, Athlete athlete) {
        Athlete updatedAthlete = athleteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Athlete not found with id " + id));
        updatedAthlete.setBiography(athlete.getBiography());
        updatedAthlete.setId(id);
        updatedAthlete.setCountry(athlete.getCountry());
        updatedAthlete.setFullName(athlete.getFullName());
        updatedAthlete.setImageUrl(athlete.getImageUrl());
        updatedAthlete.setBirthDate(athlete.getBirthDate());

        return athleteRepository.save(updatedAthlete);
    }

    @Override
    public void deleteAthleteById(Long id) {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Athlete with id" + id + " not found."));
        athleteRepository.delete(athlete);
    }
}
