package com.itscalledfreefall.news.local_news_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "media_items")
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String fileName;
    private String fileType;    // Örn: "IMAGE", "VIDEO", vb.
    private String url;
    private String thumbnailUrl;
    private String altText;
    private String caption;
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @PrePersist
    protected void onCreate() {
        if (uploadedAt == null) {
            uploadedAt = LocalDateTime.now();
        }
    }
}
