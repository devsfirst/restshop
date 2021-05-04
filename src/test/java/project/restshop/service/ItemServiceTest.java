package project.restshop.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.restshop.entity.Item;
import project.restshop.entity.Order;
import project.restshop.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired ItemService itemService;

    @Test
    void 품목저장() {
        Item item = new Item("item1", 100, 10);
        itemService.save(item);

        Item find = itemService.findById(item.getId());

        Assertions.assertThat(item.getId()).isEqualTo(find.getId());
    }

    @Test
    void 없는품목조회() {
        assertThrows(IllegalStateException.class, () -> itemService.findById(1L));
    }

    @Test
    void 모든품목조회() {
        itemService.save(new Item("item1", 1, 10));
        itemService.save(new Item("item2", 2, 20));

        List<Item> find = itemService.findAll();

        Assertions.assertThat(find.size()).isEqualTo(2);
    }

    @Test
    void 주문삭제() {
        Item item = new Item("item1", 1, 10);
        itemService.save(item);

        itemService.delete(item);

        assertThrows(IllegalStateException.class, () -> itemService.findById(item.getId()));
    }
}