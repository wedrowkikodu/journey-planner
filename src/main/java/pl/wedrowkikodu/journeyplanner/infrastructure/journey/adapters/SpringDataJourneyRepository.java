package pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.entity.JourneyEntity;

import java.util.Optional;

@Repository
public interface SpringDataJourneyRepository extends JpaRepository<JourneyEntity, Long> {
    Optional<JourneyEntity> findByName(String name);
}
