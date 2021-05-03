package project.restshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
