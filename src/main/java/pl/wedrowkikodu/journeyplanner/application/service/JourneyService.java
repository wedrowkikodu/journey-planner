package pl.wedrowkikodu.journeyplanner.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.JourneyRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JourneyService {

    private final JourneyRepository journeyRepository;

    public Long planJourney(Journey journey) {
        //any business logic operations
        return journeyRepository.save(journey);
    }

    public Optional<Journey> getJourney(Long id) {
        return journeyRepository.findById(id);
    }
}
