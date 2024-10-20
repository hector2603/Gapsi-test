package com.gapsi.articleback.application.usecase;

import com.gapsi.articleback.domain.model.Article;
import com.gapsi.articleback.domain.service.ArticleService;
import com.gapsi.articleback.infrastructure.dto.ArticleResponse;
import com.gapsi.articleback.shared.exception.ArticleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetArticleDetailsUseCase {

    @Autowired
    private ArticleService articleService;

    public ArticleResponse execute(String id) {
        Optional<Article> articleOptional = articleService.getArticleById(id);

        if (articleOptional.isEmpty()) {
            throw new ArticleNotFoundException("Article with ID " + id + " not found");
        }

        Article article = articleOptional.get();

        return ArticleResponse.builder()
                .id(article.getId())
                .name(article.getName())
                .description(article.getDescription())
                .price(article.getPrice().doubleValue())
                .model(article.getModel())
                .build();
    }
}