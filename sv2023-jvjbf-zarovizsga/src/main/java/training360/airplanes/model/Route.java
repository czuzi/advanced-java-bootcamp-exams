package training360.airplanes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "routes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Column(name = "date_of_flight")
    private LocalDate dateOfFlight;
    @ManyToOne
    private Airplane airplane;

    public Route(String departureCity, String arrivalCity, LocalDate dateOfFlight, Airplane airplane) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfFlight = dateOfFlight;
        this.airplane = airplane;
    }

    public Route(String departureCity, String arrivalCity, LocalDate dateOfFlight) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfFlight = dateOfFlight;
    }
}
