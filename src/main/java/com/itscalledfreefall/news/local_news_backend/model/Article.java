package com.itscalledfreefall.news.local_news_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 500)
    private String summary;

    private String author;
    private LocalDateTime publishedAt;
    private Integer viewCount;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaItem> mediaItems = new ArrayList<>();

    //  Article -> ArticleTag -> Tag



}

