package com.itscalledfreefall.news.local_news_backend.services;

import com.itscalledfreefall.news.local_news_backend.model.Article;
import com.itscalledfreefall.news.local_news_backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepo;

    public ArticleService(ArticleRepository articleRepo){
        this.articleRepo = articleRepo;
    }

    public List<Article> getAllArticles(){
        return  articleRepo.findAll();
    }
    public Optional<Article> getArticleById(Long id){
        return articleRepo.findById(id);
    }

    public Article saveArticle(Article article){
        return  articleRepo.save(article);
    }
    public void deleteByIdArticle(Long id){
         articleRepo.deleteById(id);
    }
}
