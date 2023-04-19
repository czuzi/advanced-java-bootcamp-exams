package training360.airplanes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplanes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airplane_type")
    private AirplaneType airplaneType;
    @Column(name = "owner_airline")
    private String ownerAirline;
//    @OneToMany
//    private List<Route> routes = new ArrayList<>();
}
