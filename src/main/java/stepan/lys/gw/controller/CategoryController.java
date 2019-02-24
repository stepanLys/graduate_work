package stepan.lys.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stepan.lys.gw.model.Category;
import stepan.lys.gw.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return new ResponseEntity<>(
                categoryService.create(category),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {

        return new ResponseEntity<>(
                categoryService.update(id, category),
                HttpStatus.OK
        );
    }


//    Пізніше видалити
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(
                categoryService.findAll(),
                HttpStatus.OK
        );
    }
}
