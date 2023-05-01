package training360.airplanes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airplanes")
@Getter
@Setter
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
    @OneToMany(mappedBy = "airplane")
    private Set<Route> routes = new HashSet<>();

    public Airplane(AirplaneType airplaneType, String ownerAirline) {
        this.airplaneType = airplaneType;
        this.ownerAirline = ownerAirline;
    }
}
