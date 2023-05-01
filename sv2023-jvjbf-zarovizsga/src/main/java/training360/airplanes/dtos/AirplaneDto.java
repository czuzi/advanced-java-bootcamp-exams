package training360.airplanes.dtos;

import lombok.*;
import training360.airplanes.model.AirplaneType;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {

    private Long id;
    private AirplaneType airplaneType;
    private String ownerAirline;
    private Set<RouteDto> routes;
}
