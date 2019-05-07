package stepan.lys.gw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stepan.lys.gw.model.Author;
import stepan.lys.gw.model.Book;
import stepan.lys.gw.repository.AuthorRepository;
import stepan.lys.gw.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author update(Long id, Author author) {
        Author oldAuthor = authorRepository.getOne(id);
        if (oldAuthor != null) {
            author.setId(oldAuthor.getId());
            create(author);

            return author;
        }

        return null;
    }
}
