package training360.airplanes.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import training360.airplanes.model.AirplaneType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAirplaneCommand {
    private AirplaneType airplaneType;
    @NotBlank(message = "Validation failed")
    private String ownerAirline;
}
