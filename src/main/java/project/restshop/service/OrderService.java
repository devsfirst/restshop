package project.restshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.restshop.entity.Order;
import project.restshop.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long save(Order order) {
        orderRepository.save(order);
        return order.getId();
    }

    public Order findById(Long id) {
        Optional<Order> find = orderRepository.findById(id);
        if (find.isEmpty()) throw new IllegalStateException("존재하지 않는 order 입니다.");
        return find.get();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
