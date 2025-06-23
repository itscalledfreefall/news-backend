package com.itscalledfreefall.news.local_news_backend.services;

import com.itscalledfreefall.news.local_news_backend.model.Category;
import com.itscalledfreefall.news.local_news_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }
    public Optional<Category> getCategoryById(Long id){
        return categoryRepo.findById(id);
    }
    public Category saveCategory(Category category){
        return categoryRepo.save(category);
    }
     public void deleteCategoryById(Long id){
        categoryRepo.deleteById(id);

     }
}
