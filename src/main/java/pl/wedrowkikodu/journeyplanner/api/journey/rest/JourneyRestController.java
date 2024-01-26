package pl.wedrowkikodu.journeyplanner.api.journey.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.journeyplanner.application.journey.JourneyOrchestrator;

@RestController
@RequestMapping("/journey")
@RequiredArgsConstructor
public class JourneyRestController {

    private final JourneyMapper journeyMapper;
    private final JourneyOrchestrator journeyOrchestrator;

    @GetMapping("/{id}")
    public ResponseEntity<JourneyDTO> getJourney(@PathVariable Long id) {
        return journeyOrchestrator.getJourney(id)
                .map(journeyMapper::mapToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> planJourney(@RequestBody JourneyDTO journeyDTO) {
        return ResponseEntity.ok(journeyOrchestrator.planJourney(journeyMapper.mapToDomain(journeyDTO)));
    }
}
