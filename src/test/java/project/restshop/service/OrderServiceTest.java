package project.restshop.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.restshop.entity.Order;
import project.restshop.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired private OrderService orderService;
    @Autowired private UserService userService;

    @Test
    void 주문저장() {
        User user = new User("user1");
        userService.save(user);

        Order order = new Order(user);
        orderService.save(order);

        Order find = orderService.findById(order.getId());

        Assertions.assertThat(order.getId()).isEqualTo(find.getId());
    }

    @Test
    void 없는주문조회() {
        assertThrows(IllegalStateException.class, () -> orderService.findById(1L));
    }

    @Test
    void 모든주문조회() {
        User user1 = new User("user1");
        User user2 = new User("user2");

        userService.save(user1);
        userService.save(user2);

        orderService.save(new Order(user1));
        orderService.save(new Order(user2));

        List<Order> find = orderService.findAll();

        Assertions.assertThat(find.size()).isEqualTo(2);
    }

    @Test
    void 주문삭제() {
        User user = new User("user1");
        userService.save(user);

        Order order = new Order(user);
        orderService.save(order);

        orderService.delete(order);

        assertThrows(IllegalStateException.class, () -> orderService.findById(order.getId()));
    }

}