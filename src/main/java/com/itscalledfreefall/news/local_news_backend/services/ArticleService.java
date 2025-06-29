package com.itscalledfreefall.news.local_news_backend.services;

import com.itscalledfreefall.news.local_news_backend.Dto.ArticleDTO;
import com.itscalledfreefall.news.local_news_backend.model.Article;
import com.itscalledfreefall.news.local_news_backend.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepo;


    private ArticleDTO convertToDto(Article article){
        ArticleDTO dto = new ArticleDTO() ;
        dto.setContent(article.getContent());
        dto.setTitle(article.getTitle());
        if(article.getAuthor()!=null){
            dto.setAuthor(article.getAuthor());
        }
        dto.setPublishedAt(article.getPublishedAt());
        return dto ;
    }


    public ArticleService(ArticleRepository articleRepo){
        this.articleRepo = articleRepo;
    }

    public Page<ArticleDTO> getAllArticles(Pageable pageable){
        Page<Article> articlesPage = articleRepo.findAll(pageable);
        return articlesPage.map(this::convertToDto);

    }
    public Optional<ArticleDTO> getArticleById(Long id){
        return articleRepo.findById(id).map(this::convertToDto);
    }

    public void deleteByIdArticle(Long id){
         articleRepo.deleteById(id);
    }
}
