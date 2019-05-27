package stepan.lys.gw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stepan.lys.gw.model.Genre;
import stepan.lys.gw.repository.GenreRepository;
import stepan.lys.gw.service.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.getOne(id);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre update(Long id, Genre genre) {
        Genre oldGenre = genreRepository.getOne(id);
        if (oldGenre != null) {
            genre.setId(oldGenre.getId());
            create(genre);

            return genre;
        }

        return null;
    }
}
