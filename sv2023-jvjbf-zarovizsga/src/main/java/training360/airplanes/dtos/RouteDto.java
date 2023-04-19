package training360.airplanes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.airplanes.model.Airplane;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Long id;
    private String departureCity;
    private String arrivalCity;
    private LocalDate dateOfFlight;
    private Airplane airplane;

    public RouteDto(String departureCity, String arrivalCity, LocalDate dateOfFlight, Airplane airplane) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfFlight = dateOfFlight;
        this.airplane = airplane;
    }

    public RouteDto(String departureCity, String arrivalCity, LocalDate dateOfFlight) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfFlight = dateOfFlight;
    }
}
