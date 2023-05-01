package training360.airplanes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import training360.airplanes.model.Airplane;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    @Query("select a from Airplane a where a.ownerAirline = :ownerAirline")
    List<Airplane> findAirplaneByOwnerAirline(String ownerAirline);
}
