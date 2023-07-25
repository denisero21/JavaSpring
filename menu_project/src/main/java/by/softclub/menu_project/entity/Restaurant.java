package by.softclub.menu_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rest_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

}