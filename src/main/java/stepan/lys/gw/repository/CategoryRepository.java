package stepan.lys.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stepan.lys.gw.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
