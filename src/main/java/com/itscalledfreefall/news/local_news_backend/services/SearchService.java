package com.itscalledfreefall.news.local_news_backend.services;

import com.itscalledfreefall.news.local_news_backend.model.Article;
import com.itscalledfreefall.news.local_news_backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final ArticleRepository articleRepo;

    public SearchService(ArticleRepository articleRepo){
        this.articleRepo = articleRepo;
    }
    public List<Article> searchArticleByKeyword(String keyword){
        List<Article> allArticles = articleRepo.findAll();
        return allArticles.stream()
                .filter(article -> article.getTitle().contains(keyword)||
                                article.getContent().contains(keyword))
                .collect(Collectors.toList());
    }
}
