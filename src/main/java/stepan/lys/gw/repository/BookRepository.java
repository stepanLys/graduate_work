package stepan.lys.gw.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stepan.lys.gw.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findByCategoryId(Long id);

}
