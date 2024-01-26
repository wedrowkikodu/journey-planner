package pl.wedrowkikodu.journeyplanner.domain.journey.model.exception;

public class JourneyAlreadyExistsException extends RuntimeException {
    public JourneyAlreadyExistsException(String name) {
        super("Journey with name " + name + " already exists");
    }
}
