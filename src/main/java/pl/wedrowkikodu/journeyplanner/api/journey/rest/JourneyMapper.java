package pl.wedrowkikodu.journeyplanner.api.journey.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

@Component
public class JourneyMapper {

    private final ModelMapper modelMapper;

    public JourneyMapper(@Qualifier("Rest") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public JourneyDTO mapToDTO(Journey journey) {
        return modelMapper.map(journey, JourneyDTO.class);
    }

    public Journey mapToDomain(JourneyDTO journeyDTO) {
        return modelMapper.map(journeyDTO, Journey.class);
    }
}
