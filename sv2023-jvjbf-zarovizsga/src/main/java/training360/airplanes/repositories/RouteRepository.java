package training360.airplanes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.airplanes.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
