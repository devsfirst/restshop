package project.restshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}
