package com.itscalledfreefall.news.local_news_backend.exceptions;

public class ArticleNotFoundEx extends RuntimeException {
    public ArticleNotFoundEx(String message) {
        super(message);
    }
}
