package com.itscalledfreefall.news.local_news_backend.repository;

import com.itscalledfreefall.news.local_news_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
