package pl.wedrowkikodu.journeyplanner.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.wedrowkikodu.journeyplanner.api.dto.JourneyDTO;
import pl.wedrowkikodu.journeyplanner.domain.journey.model.Journey;

@Component
@RequiredArgsConstructor
public class JourneyMapper {

    private final ModelMapper modelMapper;

    public JourneyDTO mapToDTO(Journey journey) {
        return modelMapper.map(journey, JourneyDTO.class);
    }

    public Journey mapToDomain(JourneyDTO journeyDTO) {
        return modelMapper.map(journeyDTO, Journey.class);
    }
}
