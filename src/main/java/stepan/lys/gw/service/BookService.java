package stepan.lys.gw.service;

import stepan.lys.gw.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book findById(Long id);

    List<Book> findAll();

    void deleteBook(Long id);

    Book update(Long id, Book book);

//    List<Book> findBookByCategoryId(Long id);

}
