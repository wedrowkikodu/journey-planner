package pl.wedrowkikodu.journeyplanner.domain.journey.model.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Long id) {
        super("City with id " + id + " not found");
    }
}
