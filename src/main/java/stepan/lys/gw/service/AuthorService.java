package stepan.lys.gw.service;

import stepan.lys.gw.model.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    Author findById(Long id);

    List<Author> findAll();

    void deleteAuthor(Long id);

    Author update(Long id, Author author);


}
