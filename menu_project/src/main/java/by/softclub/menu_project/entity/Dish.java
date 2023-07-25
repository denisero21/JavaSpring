package by.softclub.menu_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dish")
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    public Dish(Restaurant restaurant, String name, Integer cost) {
        this.restaurant = restaurant;
        this.name = name;
        this.cost = cost;
    }
}
