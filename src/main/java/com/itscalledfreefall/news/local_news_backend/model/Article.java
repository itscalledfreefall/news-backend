package com.itscalledfreefall.news.local_news_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Title cannot be blank")
    @Size(max =220, message = "title is above 220 character please shorten it! ")
    private String title;


    @NotBlank(message = "content column cannot be blank")
    @Column(columnDefinition = "TEXT")
    @Size(min = 25,message = "content must be at least 25 characters")
    private String content;

    private String author;
    private LocalDateTime publishedAt;
    private Integer viewCount;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaItem> mediaItems = new ArrayList<>();

    //  Article -> ArticleTag -> Tag



}

