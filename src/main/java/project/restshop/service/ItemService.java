package project.restshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.restshop.entity.Item;
import project.restshop.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long save(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public Item findById(Long id) {
        Optional<Item> find = itemRepository.findById(id);
        if (find.isEmpty()) throw new IllegalStateException("존재하지 않는 item 입니다.");
        return find.get();
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
