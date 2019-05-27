package stepan.lys.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepan.lys.gw.model.Genre;
import stepan.lys.gw.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<Genre> add(@RequestBody Genre genre) {
        return new ResponseEntity<>(
                genreService.create(genre),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return new ResponseEntity<>(
                genreService.findAll(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> update(@PathVariable Long id,
                                        @RequestBody Genre genre) {
        return new ResponseEntity<>(
                genreService.update(id, genre),
                HttpStatus.OK
        );
    }
}
