package pl.wedrowkikodu.journeyplanner.application.journey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.JourneyFacade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JourneyOrchestrator {

    private final JourneyFacade journeyFacade;

    @Transactional
    public Long planJourney(Journey journey) {
        //any additional logic like handling transactioning, logging or publishing some messages;
        return journeyFacade.plan(journey);
    }

    public Optional<Journey> getJourney(Long id) {
        return journeyFacade.findById(id);
    }
}
