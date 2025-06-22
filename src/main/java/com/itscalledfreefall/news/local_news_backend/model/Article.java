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
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 500)
    private String summary;

    private String author;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
    private boolean featured;
    private boolean breaking;
    private Integer viewCount;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaItem> mediaItems = new ArrayList<>();

    //  Article -> ArticleTag -> Tag
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleTag> articleTags = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // tag add
    public void addTag(Tag tag) {
        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticle(this);
        articleTag.setTag(tag);
        articleTag.setTaggedAt(LocalDateTime.now());
        articleTags.add(articleTag);
    }

    // tag delete
    public void removeTag(Tag tag) {
        articleTags.removeIf(articleTag -> articleTag.getTag().equals(tag));
    }
}

