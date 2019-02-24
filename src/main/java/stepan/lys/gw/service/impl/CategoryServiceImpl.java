package stepan.lys.gw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stepan.lys.gw.model.Category;
import stepan.lys.gw.repository.CategoryRepository;
import stepan.lys.gw.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Long id, Category newCategory) {
        Category oldCategory = categoryRepository.getOne(id);
        if (oldCategory != null) {
            newCategory.setId(oldCategory.getId());
            create(newCategory);

            return newCategory;
        }

        return null;
    }
}
