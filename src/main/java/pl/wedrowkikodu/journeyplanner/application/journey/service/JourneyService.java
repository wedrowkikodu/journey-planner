package pl.wedrowkikodu.journeyplanner.application.journey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.service.JourneyFacade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JourneyService {

    private final JourneyFacade journeyFacade;

    public Long planJourney(Journey journey) {
        //any business logic operations
        journeyFacade.validateJourney(journey);
        return journeyFacade.createJourney(journey);
    }

    public Optional<Journey> getJourney(Long id) {
        return journeyFacade.findById(id);
    }
}
