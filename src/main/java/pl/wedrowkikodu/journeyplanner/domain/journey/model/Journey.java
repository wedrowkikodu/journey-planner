package pl.wedrowkikodu.journeyplanner.domain.journey.model;

public record Journey(Long id, String name, City departurePoint, City arrivalPoint, String description) {

}
