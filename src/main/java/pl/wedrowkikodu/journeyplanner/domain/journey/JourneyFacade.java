package pl.wedrowkikodu.journeyplanner.domain.journey;

import lombok.RequiredArgsConstructor;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.exception.JourneyAlreadyExistsException;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.FindJourney;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.PlanJourney;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.outgoing.JourneyRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class JourneyFacade implements FindJourney, PlanJourney {

    private final JourneyRepository journeyRepository;

    @Override
    public Long plan(Journey journey) {
        //any business logic operations
        validate(journey);
        return create(journey);
    }

    private Long create(Journey journey) {
        return journeyRepository.save(journey);
    }

    private void validate(Journey journey) {
        //any validation operations
        findByName(journey.name()).orElseThrow(() -> new JourneyAlreadyExistsException(journey.name()));
    }

    private Optional<Journey> findByName(String name) {
        return journeyRepository.findByName(name);
    }

    public Optional<Journey> findById(Long id) {
        return journeyRepository.findById(id);
    }

}
