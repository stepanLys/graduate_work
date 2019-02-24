package stepan.lys.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stepan.lys.gw.model.Book;
import stepan.lys.gw.service.BookService;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book) {
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

    @GetMapping("/category")
    public ResponseEntity<List<Book>> findByCategoryId(@RequestParam Long id) {
        return new ResponseEntity<>(
                bookService.findBookByCategoryId(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
