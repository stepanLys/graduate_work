package stepan.lys.gw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stepan.lys.gw.model.Book;
import stepan.lys.gw.model.Genre;
import stepan.lys.gw.repository.BookRepository;
import stepan.lys.gw.repository.GenreRepository;
import stepan.lys.gw.service.BookService;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book create(Book book) {

        return bookRepository.save(book);
//        return null;

    }


    @Override
    public Book findById(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id, Book book) {
        Book oldBook = bookRepository.getOne(id);
        if (oldBook != null) {
            book.setId(oldBook.getId());
            create(book);

            return book;
        }

        return null;
    }

    //    @Override
//    public List<Book> findBookByCategoryId(Long id) {
//        return bookRepository.findByCategoryId(id);
//    }
}
