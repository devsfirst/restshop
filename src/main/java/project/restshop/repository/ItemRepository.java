package project.restshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restshop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
