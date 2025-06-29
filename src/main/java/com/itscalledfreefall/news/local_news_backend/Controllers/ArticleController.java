package com.itscalledfreefall.news.local_news_backend.Controllers;


import com.itscalledfreefall.news.local_news_backend.Dto.ArticleDTO;
import com.itscalledfreefall.news.local_news_backend.model.Article;
import com.itscalledfreefall.news.local_news_backend.services.ArticleService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService service;


    public ArticleController(ArticleService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ArticleDTO>> getAllArticles(Pageable pageable){
        Page<ArticleDTO> articlesPage = service.getAllArticles(pageable);
        return ResponseEntity.ok(articlesPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id){

        Optional<ArticleDTO> articleDto = service.getArticleById(id);
        return articleDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdArticle(@PathVariable Long id ){
        service.deleteByIdArticle(id);
        return ResponseEntity.noContent().build();
    }


}
