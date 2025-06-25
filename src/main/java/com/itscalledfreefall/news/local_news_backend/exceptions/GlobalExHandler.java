package com.itscalledfreefall.news.local_news_backend.exceptions;

import com.itscalledfreefall.news.local_news_backend.model.Category;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExHandler {

    @ExceptionHandler(ArticleNotFoundEx.class)
    public ResponseEntity<String>  handleArticleNotFoundEx(ArticleNotFoundEx ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(CategoryNotFoundEx.class)
    public ResponseEntity<String> handleCategoryNotFoundEx(CategoryNotFoundEx ex ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
