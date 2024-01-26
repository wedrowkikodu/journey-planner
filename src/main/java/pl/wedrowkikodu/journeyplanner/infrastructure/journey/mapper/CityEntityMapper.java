package pl.wedrowkikodu.journeyplanner.infrastructure.journey.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.City;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.entity.CityEntity;

@Component
public class CityEntityMapper {
    private final ModelMapper modelMapper;

    public CityEntityMapper(@Qualifier("JourneyDomain") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CityEntity mapToEntity(City city) {
        return modelMapper.map(city, CityEntity.class);
    }

    public City mapToDomain(CityEntity cityEntity) {
        return modelMapper.map(cityEntity, City.class);
    }
}
