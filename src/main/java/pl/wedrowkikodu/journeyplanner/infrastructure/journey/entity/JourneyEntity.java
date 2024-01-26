package pl.wedrowkikodu.journeyplanner.infrastructure.journey.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JOURNEYS")
@Getter
@Setter
public class JourneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOURNEYS_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPARTURE_POINT_ID")
    private CityEntity departurePoint;

    @ManyToOne
    @JoinColumn(name = "ARRIVAL_POINT_ID")
    private CityEntity arrivalPoint;

    @Column(name = "DESCRIPTION")
    private String description;
}
