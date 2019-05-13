package rsi.rest.crud.repository;

import org.springframework.stereotype.Repository;
import rsi.rest.crud.to.Scroll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScrollRepository {

    private long nextId = 1;

    private Map<Long, Scroll> scrolls = new HashMap<>();

    public Scroll save(Scroll scroll) {
        scroll.setId(nextId++);
        scrolls.put(scroll.getId(), scroll);
        return scroll;
    }

    public void delete(Long id) {
        scrolls.remove(id);
    }

    public void update(Scroll scroll) {
        scrolls.put(scroll.getId(), scroll);
    }

    public boolean contains(Long id) {
        return id != null && scrolls.containsKey(id);
    }

    public Scroll get(Long id) {
        return scrolls.get(id);
    }

    public List<Scroll> getAll() {
        return new ArrayList<>(scrolls.values());
    }
}
