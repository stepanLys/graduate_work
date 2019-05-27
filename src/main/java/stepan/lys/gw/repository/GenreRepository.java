package stepan.lys.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stepan.lys.gw.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
