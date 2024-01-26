package pl.wedrowkikodu.journeyplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.wedrowkikodu.journeyplanner.infrastructure.JourneyPlannerConfig;
import pl.wedrowkikodu.journeyplanner.infrastructure.journey.JourneyDomainConfig;

@SpringBootApplication
@Import({
	JourneyPlannerConfig.class,
	JourneyDomainConfig.class
})
public class JourneyPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JourneyPlannerApplication.class, args);
	}

}
