package training360.airplanes.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.airplanes.dtos.AirplaneDto;
import training360.airplanes.dtos.CreateAirplaneCommand;
import training360.airplanes.dtos.CreateRouteCommand;
import training360.airplanes.dtos.RouteDto;
import training360.airplanes.services.AirplaneRouteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airplanes")
@AllArgsConstructor
public class AirplaneRouteController {

    private AirplaneRouteService airplaneRouteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneDto createAirplane(@Valid @RequestBody CreateAirplaneCommand command) {
        return airplaneRouteService.createAirplane(command);
    }

    @PostMapping("/{id}/routes")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteDto createRoute(@PathVariable("id") long id, @Valid @RequestBody CreateRouteCommand command) {
        return airplaneRouteService.createRoute(id, command);
    }

    @GetMapping
    public List<AirplaneDto> getAllAirplanes(@RequestParam Optional<String> ownerAirline) {
        return airplaneRouteService.findAllAirplanesByAirline(ownerAirline);
    }

    @PutMapping("/{id}/routes/{routeId}")
    public AirplaneDto cancelFlight(@PathVariable("id") long planeId, @PathVariable("routeId") long routeId){
        return airplaneRouteService.cancelFlight(planeId,routeId);
    }
}
