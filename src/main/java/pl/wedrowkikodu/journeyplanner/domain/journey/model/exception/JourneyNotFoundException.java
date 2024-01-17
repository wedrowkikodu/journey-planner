package pl.wedrowkikodu.journeyplanner.domain.journey.model.exception;

public class JourneyNotFoundException extends RuntimeException {
    public JourneyNotFoundException(Long id) {
        super("Journey with id " + id + " not found");
    }
}
