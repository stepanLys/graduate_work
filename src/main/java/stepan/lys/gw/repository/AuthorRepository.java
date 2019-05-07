package stepan.lys.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stepan.lys.gw.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
