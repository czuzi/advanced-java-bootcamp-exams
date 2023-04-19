package training360.airplanes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.airplanes.model.Airplane;

import java.util.List;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    List<Airplane> findAirplaneByOwnerAirline(String name);
}
