package training360.airplanes.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteCommand {

    @NotBlank(message = "Validation failed")
    private String departureCity;
    @NotBlank(message = "Validation failed")
    private String arrivalCity;
    @Future(message = "Validation failed")
    private LocalDate dateOfFlight;
}
