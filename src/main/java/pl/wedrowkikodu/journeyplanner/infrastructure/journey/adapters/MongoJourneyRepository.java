package pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters;

import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.outgoing.JourneyRepository;

import java.util.Optional;

public class MongoJourneyRepository implements JourneyRepository {

    @Override
    public Long save(Journey journey) {
        return null;
    }

    @Override
    public Optional<Journey> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Journey> findByName(String name) {
        return Optional.empty();
    }
}
