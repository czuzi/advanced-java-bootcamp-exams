package training360.airplanes.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import training360.airplanes.dtos.*;
import training360.airplanes.exceptions.AirplaneNotAvailableOnDateException;
import training360.airplanes.exceptions.AirplaneNotFoundException;
import training360.airplanes.exceptions.RouteNotFoundException;
import training360.airplanes.model.Airplane;
import training360.airplanes.model.Route;
import training360.airplanes.repositories.AirplaneRepository;
import training360.airplanes.repositories.RouteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirplaneRouteService {

    private AirplaneRepository airplaneRepository;
    private RouteRepository routeRepository;
    private AirplanesConverter converter;

    @Transactional
    public AirplaneDto createAirplane(CreateAirplaneCommand command) {
        Airplane airplane = new Airplane(command.getAirplaneType(), command.getOwnerAirline());
        airplaneRepository.save(airplane);
        return converter.convert(airplane);
    }

    public List<AirplaneDto> findAllAirplanesByAirline(Optional<String> ownerAirline) {
        List<Airplane> airplanes;

        if (ownerAirline.isPresent()) {
            airplanes = airplaneRepository.findAirplaneByOwnerAirline(ownerAirline.get());
        } else {
            airplanes = airplaneRepository.findAll();
        }

        return converter.convertAirplanes(airplanes);
    }

    public RouteDto createRoute(long id, CreateRouteCommand command) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(() ->
                new AirplaneNotFoundException("Airplane not found with id:" + id));
        validateDate(command, airplane);
        Route route = new Route(command.getDepartureCity(), command.getArrivalCity(), command.getDateOfFlight());
        route.setAirplane(airplane);
        routeRepository.save(route);
        return converter.convert(route);
    }

    private void validateDate(CreateRouteCommand command, Airplane airplane) {
        List<LocalDate> flightDates = airplane.getRoutes().stream().map(Route::getDateOfFlight).toList();
        LocalDate date = command.getDateOfFlight();
        if (flightDates.contains(date)) {
            throw new AirplaneNotAvailableOnDateException("Flight is not free on " + date.toString());
        }
    }

    @Transactional
    public AirplaneDto cancelFlight(long planeId, long routeId) {
        Airplane airplane = airplaneRepository.findById(planeId).orElseThrow(() ->
                new AirplaneNotFoundException("Airplane not found with id:" + planeId));
        Route route = routeRepository.findById(routeId).orElseThrow(() ->
                new RouteNotFoundException("Route not found with id: " + routeId));
        if(route.getAirplane() == null || route.getAirplane().getId() != airplane.getId()){
            throw new RouteNotFoundException("Route not found with id: " + routeId);
        }
        route.setAirplane(null);
        airplane.getRoutes().remove(route);
        return converter.convert(airplane);
    }
}
