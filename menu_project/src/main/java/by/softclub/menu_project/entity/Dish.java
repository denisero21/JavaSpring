package by.softclub.menu_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private long id;

    @ManyToMany
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private List<MenuCategory> category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;
}
