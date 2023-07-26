package by.softclub.menu_project.entity;

import by.softclub.menu_project.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "post")
    private String post;

    @Column(name = "role")
    private String userRole;

    @OneToOne
    private User user;
}
