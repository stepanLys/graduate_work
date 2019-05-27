package stepan.lys.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepan.lys.gw.model.Book;
import stepan.lys.gw.model.Genre;
import stepan.lys.gw.service.BookService;
import stepan.lys.gw.service.GenreService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;


    @Autowired
    public BookController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book) {
        System.out.println(book);

//        Set<Long> genres = book.getGenresId();
//
//        genres.forEach(g -> {
//            Genre byId = genreService.findById(g);
//            book.addGenre(byId);
//        });

        System.out.println(book);

        return new ResponseEntity<>(
                bookService.create(book),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Long id) {
        return new ResponseEntity<>(
                bookService.findById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return new ResponseEntity<>(
                bookService.findAll(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        return new ResponseEntity<>(
                bookService.update(id, book),
                HttpStatus.OK
        );
    }

//    @GetMapping("/category")
//    public ResponseEntity<List<Book>> findByCategoryId(@RequestParam Long id) {
//        return new ResponseEntity<>(
//                bookService.findBookByCategoryId(id),
//                HttpStatus.OK
//        );
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
