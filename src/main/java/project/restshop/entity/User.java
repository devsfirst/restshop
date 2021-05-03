package project.restshop.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();
}
