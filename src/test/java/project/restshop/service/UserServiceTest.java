package project.restshop.service;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.restshop.entity.User;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    void 회원가입() {
        User user = new User("user1");
        userService.save(user);
        User findUser = userService.findById(user.getId());
        Assertions.assertThat(user.getId()).isEqualTo(findUser.getId());
    }
}