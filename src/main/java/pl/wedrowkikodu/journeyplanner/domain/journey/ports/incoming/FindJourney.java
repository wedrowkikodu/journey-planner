package pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming;

import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

import java.util.Optional;

public interface FindJourney {
    Optional<Journey> findById(Long id);
}
