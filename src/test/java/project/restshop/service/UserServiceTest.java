package project.restshop.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.restshop.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceTest {

    @Autowired private UserService userService;

    @Test
    void 회원저장() {
        User user = new User("user1");
        userService.save(user);

        User find = userService.findById(user.getId());

        Assertions.assertThat(user.getId()).isEqualTo(find.getId());
    }

    @Test
    void 없는회원조회() {
        assertThrows(IllegalStateException.class, () -> userService.findById(1L));
    }

    @Test
    void 모든회원조회() {
        userService.save(new User("user1"));
        userService.save(new User("user2"));

        List<User> find = userService.findAll();

        Assertions.assertThat(find.size()).isEqualTo(2);
    }

    @Test
    void 회원삭제() {
        User user = new User("user1");
        userService.save(user);

        userService.delete(user);

        assertThrows(IllegalStateException.class, () -> userService.findById(user.getId()));
    }
}