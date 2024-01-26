package pl.wedrowkikodu.journeyplanner.application.journey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.FindJourney;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.PlanJourney;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JourneyOrchestrator {

    private final PlanJourney planJourney;
    private final FindJourney findJourney;

    @Transactional
    public Long planJourney(Journey journey) {
        //any additional logic like handling transactioning, logging or publishing some messages.
        return planJourney.plan(journey);
    }

    public Optional<Journey> getJourney(Long id) {
        return findJourney.findById(id);
    }
}
