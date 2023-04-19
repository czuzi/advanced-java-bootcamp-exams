package training360.airplanes.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.airplanes.model.AirplaneType;
import training360.airplanes.model.Route;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {

    private Long id;
    private AirplaneType airplaneType;
    private String ownerAirline;
    private Set<Route> routes = new HashSet<>();
}
