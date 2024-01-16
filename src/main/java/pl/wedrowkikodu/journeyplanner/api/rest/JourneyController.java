package pl.wedrowkikodu.journeyplanner.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wedrowkikodu.journeyplanner.api.dto.JourneyDTO;
import pl.wedrowkikodu.journeyplanner.api.mapper.JourneyMapper;
import pl.wedrowkikodu.journeyplanner.application.service.JourneyService;

@RestController
@RequestMapping("/journey")
@RequiredArgsConstructor
public class JourneyController {

    private final JourneyMapper journeyMapper;
    private final JourneyService journeyService;

    @GetMapping("/{id}")
    public ResponseEntity<JourneyDTO> getJourney(@PathVariable Long id) {
        return journeyService.getJourney(id)
                .map(journeyMapper::mapToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> planJourney(@RequestBody JourneyDTO journeyDTO) {
        return ResponseEntity.ok(journeyService.planJourney(journeyMapper.mapToDomain(journeyDTO)));
    }
}
