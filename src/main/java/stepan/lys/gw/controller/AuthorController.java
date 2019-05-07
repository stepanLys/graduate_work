package stepan.lys.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepan.lys.gw.model.Author;
import stepan.lys.gw.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> add(@RequestBody Author author) {
        return new ResponseEntity<>(
                authorService.create(author),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthor(@PathVariable Long id) {
        return new ResponseEntity<>(
                authorService.findById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return new ResponseEntity<>(
                authorService.findAll(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        return new ResponseEntity<>(
                authorService.update(id, author),
                HttpStatus.OK
        );
    }
}
