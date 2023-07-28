package by.softclub.menu_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "restaurant_table")
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Integer tableNumber;

    @Column(name = "seats")
    private Integer seatsNumber;

    @Column(name = "free")
    private Boolean isFree;

    @OneToMany(mappedBy = "table")
    private List<Reservation> reservations;
}
