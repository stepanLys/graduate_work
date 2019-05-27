package stepan.lys.gw.service;

import stepan.lys.gw.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();

    Genre create(Genre genre);

    Genre findById(Long id);

    void deleteGenre(Long id);

    Genre update(Long id, Genre genre);
}
