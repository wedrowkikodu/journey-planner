package pl.wedrowkikodu.journeyplanner.infrastructure.journey.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.entity.JourneyEntity;

@Component
public class JourneyEntityMapper {
    private final ModelMapper modelMapper;
    private final CityEntityMapper cityEntityMapper;

    public JourneyEntityMapper(@Qualifier("JourneyDomain") ModelMapper modelMapper, CityEntityMapper cityEntityMapper) {
        this.modelMapper = modelMapper;
        this.cityEntityMapper = cityEntityMapper;
    }

    public JourneyEntity mapToEntity(Journey journey) {
        if (journey == null) {
            return null;
        }

        JourneyEntity journeyEntity = modelMapper.map(journey, JourneyEntity.class);
        journeyEntity.setDeparturePoint(cityEntityMapper.mapToEntity(journey.departurePoint()));
        journeyEntity.setArrivalPoint(cityEntityMapper.mapToEntity(journey.arrivalPoint()));
        return journeyEntity;
    }

    public Journey mapToDomain(JourneyEntity journeyEntity) {
        if (journeyEntity == null) {
            return null;
        }

        return new Journey(
            journeyEntity.getId(),
            journeyEntity.getName(),
            cityEntityMapper.mapToDomain(journeyEntity.getDeparturePoint()),
            cityEntityMapper.mapToDomain(journeyEntity.getArrivalPoint()),
            journeyEntity.getDescription()
        );
    }
}
