package training360.airplanes.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.airplanes.dtos.AirplaneDto;
import training360.airplanes.dtos.CreateAirplaneCommand;
import training360.airplanes.dtos.CreateRouteCommand;
import training360.airplanes.dtos.RouteDto;
import training360.airplanes.services.AirplaneService;

@RestController
@RequestMapping("/api/airplanes")
@AllArgsConstructor
public class AirplaneController {

    private AirplaneService airplaneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneDto createAirplane(@Valid @RequestBody CreateAirplaneCommand command) {
        return airplaneService.createAirplane(command);
    }

    @PostMapping("/api/airplanes/{id}/routes")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteDto createRoute(@PathVariable long id, @Valid @RequestBody CreateRouteCommand command) {
        return airplaneService.createRoute(id, command);
    }
}
