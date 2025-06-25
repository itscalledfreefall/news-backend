package com.itscalledfreefall.news.local_news_backend.Controllers;

import com.itscalledfreefall.news.local_news_backend.exceptions.ArticleNotFoundEx;
import com.itscalledfreefall.news.local_news_backend.model.Article;
import com.itscalledfreefall.news.local_news_backend.services.ArticleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService service;


    public ArticleController(ArticleService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles(){
        List<Article> articles = service.getAllArticles();
        return ResponseEntity.ok(articles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id){
        try{
        Optional<Article> article = service.getArticleById(id);
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());}

        catch (ArticleNotFoundEx ex ){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article savedArticle = service.saveArticle(article);
        return ResponseEntity.ok(savedArticle);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdArticle(@PathVariable Long id ){
        service.deleteByIdArticle(id);
        return ResponseEntity.noContent().build();
    }


}
