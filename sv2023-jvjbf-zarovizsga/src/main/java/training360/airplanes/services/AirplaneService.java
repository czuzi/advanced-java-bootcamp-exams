package training360.airplanes.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import training360.airplanes.dtos.*;
import training360.airplanes.model.Airplane;
import training360.airplanes.model.Route;
import training360.airplanes.repositories.AirplaneRepository;
import training360.airplanes.repositories.RouteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirplaneService {

    private AirplaneRepository airplaneRepository;
    private RouteRepository routeRepository;
    private AirplanesConverter converter;

    @Transactional
    public AirplaneDto createAirplane(CreateAirplaneCommand command) {
        Airplane airplane = new Airplane();
        airplane.setAirplaneType(command.getAirplaneType());
        airplane.setOwnerAirline(command.getOwnerAirline());
        airplaneRepository.save(airplane);
        return converter.convert(airplane);
    }

    public List<AirplaneDto> findAllAirplanesByAirline(Optional<String> company) {
        List<Airplane> airplanes = new ArrayList<>();

        if (company.isEmpty()) {
            airplanes = airplaneRepository.findAll();
        } else {
            airplanes = airplaneRepository.findAirplaneByOwnerAirline(company.orElseThrow());
        }

        return converter.convertAirplanes(airplanes);
    }

    public RouteDto createRoute(long id, CreateRouteCommand command) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow();
        Route route = new Route(command.getDepartureCity(), command.getArrivalCity(), command.getDateOfFlight());
        airplane.addRoute(route);
        routeRepository.save(route);
        return converter.convert(route);
    }
}
