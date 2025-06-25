package com.itscalledfreefall.news.local_news_backend.exceptions;

public class CategoryNotFoundEx extends RuntimeException {
    public CategoryNotFoundEx(String message) {
        super(message);
    }
}
