package training360.airplanes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training360.airplanes.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
