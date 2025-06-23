package com.itscalledfreefall.news.local_news_backend.Controllers;

import com.itscalledfreefall.news.local_news_backend.model.Category;
import com.itscalledfreefall.news.local_news_backend.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoriesList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoriesList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoriesById(@PathVariable Long id){
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category createdCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(createdCategory);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();

    }
}

