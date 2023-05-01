package training360.airplanes.dtos;

import lombok.*;
import training360.airplanes.model.Airplane;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Long id;
    private String departureCity;
    private String arrivalCity;
    private LocalDate dateOfFlight;
}
