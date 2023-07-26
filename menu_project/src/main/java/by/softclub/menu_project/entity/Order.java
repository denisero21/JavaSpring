package by.softclub.menu_project.entity;

import by.softclub.menu_project.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status")
    private String status;

    @Column(name = "cost")
    private Integer cost;

    @OneToMany(mappedBy = "order")
    private List<Dish> dishes;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    @OneToOne
    private Payment payment;

}
