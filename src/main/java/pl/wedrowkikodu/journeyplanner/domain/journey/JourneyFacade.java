package pl.wedrowkikodu.journeyplanner.domain.journey;

import pl.wedrowkikodu.journeyplanner.domain.journey.model.City;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

import java.util.Optional;

public class JourneyFacade {

    public Long plan(Journey journey) {
        //any business logic
        validate(journey);
        return create(journey);
    }

    public Long create(Journey journey) {
        return journey.id();
    }

    public void validate(Journey journey) {
        //any validation operations
    }

    public Optional<Journey> findById(Long id) {
        return Optional.of(createJourney(id, "TestJourney"));
    }

    private Journey createJourney(Long id, String name) {
        return new Journey(id, "name", new City(1L, "Rzeszów"),
            new City(2L, "Kraków"), "description");
    }

}
