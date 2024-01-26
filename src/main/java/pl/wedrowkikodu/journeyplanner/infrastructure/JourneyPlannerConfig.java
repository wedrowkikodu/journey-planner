package pl.wedrowkikodu.journeyplanner.infrastructure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class JourneyPlannerConfig {

    @Bean("Rest")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
