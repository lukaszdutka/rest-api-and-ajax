package rsi.rest.crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsi.rest.crud.repository.ScrollRepository;
import rsi.rest.crud.to.Scroll;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("rsi/scrolls")
@RestController
public class CrudController {

    private final ScrollRepository scrollRepository;

    @GetMapping
    public List<Scroll> getAllScrolls() {
        return scrollRepository.getAll();
    }

    @GetMapping(path = "/{scrollId}")
    public Scroll getScrollById(@PathVariable Long scrollId) {
        return scrollRepository.get(scrollId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Scroll saveScroll(@RequestBody Scroll scroll) {
        return scrollRepository.save(scroll);
    }

    @DeleteMapping(path = "/{scrollId}")
    public ResponseEntity deleteScroll(@PathVariable Long scrollId) {
        if (!scrollRepository.contains(scrollId)) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
        scrollRepository.delete(scrollId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateScroll(@RequestBody Scroll scroll) {
        if (!scrollRepository.contains(scroll.getId())) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
        scrollRepository.update(scroll);
        return new ResponseEntity(HttpStatus.OK);
    }
}
