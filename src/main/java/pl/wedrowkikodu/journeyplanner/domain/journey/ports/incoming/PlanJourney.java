package pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming;

import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

public interface PlanJourney {
    Long plan(Journey journey);
}
