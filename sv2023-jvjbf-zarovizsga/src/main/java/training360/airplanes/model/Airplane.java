package training360.airplanes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Enumerated(EnumType.STRING)
    private AirplaneType airplaneType;
    @Column(name = "owner_airline")
    private String ownerAirline;
    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL)
    private Set<Route> routes = new HashSet<>();

    public Airplane(AirplaneType airplaneType, String ownerAirline) {
        this.airplaneType = airplaneType;
        this.ownerAirline = ownerAirline;
    }

    public void addRoute (Route route) {
        routes.add(route);
        route.setAirplane(this);
    }
}
