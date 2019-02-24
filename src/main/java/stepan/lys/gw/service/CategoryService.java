package stepan.lys.gw.service;

import stepan.lys.gw.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category findById(Long id);

    List<Category> findAll();

    void deleteCategory(Long id);

    Category update(Long id, Category newCategory);

}
