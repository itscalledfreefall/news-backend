package com.itscalledfreefall.news.local_news_backend.repository;

import com.itscalledfreefall.news.local_news_backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {


}
