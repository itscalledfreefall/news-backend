package com.itscalledfreefall.news.local_news_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "article_tags")
public class ArticleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    private LocalDateTime taggedAt;

    @PrePersist
    protected void onCreate() {
        if (taggedAt == null) {
            taggedAt = LocalDateTime.now();
        }
    }
}
