package project.restshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.restshop.entity.User;
import project.restshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User findById(Long id) {
        Optional<User> find = userRepository.findById(id);
        if (find.isEmpty()) throw new IllegalStateException("존재하지 않는 user 입니다.");
        return find.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
