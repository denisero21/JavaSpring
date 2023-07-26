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
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
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
