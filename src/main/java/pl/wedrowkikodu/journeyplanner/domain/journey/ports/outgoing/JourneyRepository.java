package pl.wedrowkikodu.journeyplanner.domain.journey.ports.outgoing;

import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

import java.util.Optional;

public interface JourneyRepository {
    Long save(Journey journey);
    Optional<Journey> findById(Long id);
    Optional<Journey> findByName(String name);
}
