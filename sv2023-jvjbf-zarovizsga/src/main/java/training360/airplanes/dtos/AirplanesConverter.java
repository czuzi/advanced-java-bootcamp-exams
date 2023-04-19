package training360.airplanes.dtos;

import org.mapstruct.Mapper;
import training360.airplanes.model.Airplane;
import training360.airplanes.model.Route;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirplanesConverter {
    AirplaneDto convert(Airplane airplane);
    List<AirplaneDto> convertAirplanes(List<Airplane> airplanes);
    RouteDto convert(Route route);
    List<RouteDto> convertRoutes(List<Route> route);
}
