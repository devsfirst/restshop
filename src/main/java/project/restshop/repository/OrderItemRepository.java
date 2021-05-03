package project.restshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restshop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
