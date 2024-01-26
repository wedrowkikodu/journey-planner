package pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters;

import lombok.RequiredArgsConstructor;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.outgoing.JourneyRepository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.mapper.JourneyEntityMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaJourneyRepository implements JourneyRepository {

    private final JourneyEntityMapper journeyEntityMapper;
    private final SpringDataJourneyRepository springDataJourneyRepository;

    @Override
    public Long save(Journey journey) {
        return springDataJourneyRepository.save(journeyEntityMapper.mapToEntity(journey)).getId();
    }

    @Override
    public Optional<Journey> findById(Long id) {
        return springDataJourneyRepository.findById(id)
            .map(journeyEntityMapper::mapToDomain);
    }

    @Override
    public Optional<Journey> findByName(String name) {
        return springDataJourneyRepository.findByName(name)
            .map(journeyEntityMapper::mapToDomain);
    }
}
