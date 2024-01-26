package pl.wedrowkikodu.journeyplanner.infrastructure.journey;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import pl.wedrowkikodu.journeyplanner.domain.journey.JourneyFacade;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.FindJourney;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.incoming.PlanJourney;
import pl.wedrowkikodu.journeyplanner.domain.journey.ports.outgoing.JourneyRepository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters.JpaJourneyRepository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters.MongoJourneyRepository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.adapters.SpringDataJourneyRepository;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.mapper.JourneyEntityMapper;

public class JourneyDomainConfig {

    @Bean("JourneyDomain")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean("jpa")
    public JourneyRepository jpaJourneyRepository(JourneyEntityMapper journeyEntityMapper,
                                                  SpringDataJourneyRepository springDataJourneyRepository) {
        return new JpaJourneyRepository(journeyEntityMapper, springDataJourneyRepository);
    }

    @Bean("mongo")
    public JourneyRepository mongoJourneyRepository() {
        return new MongoJourneyRepository();
    }

    @Bean
    public FindJourney findJourney(@Qualifier("mongo") JourneyRepository journeyRepository) {
        return new JourneyFacade(journeyRepository);
    }

    @Bean
    public PlanJourney planJourney(@Qualifier("jpa") JourneyRepository journeyRepository) {
        return new JourneyFacade(journeyRepository);
    }

}
