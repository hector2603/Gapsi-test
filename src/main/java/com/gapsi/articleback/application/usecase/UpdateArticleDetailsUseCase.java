package com.gapsi.articleback.application.usecase;

import com.gapsi.articleback.domain.model.Article;
import com.gapsi.articleback.domain.service.ArticleService;
import com.gapsi.articleback.infrastructure.dto.UpdateArticleRequest;
import com.gapsi.articleback.shared.exception.ArticleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateArticleDetailsUseCase {

    @Autowired
    private ArticleService articleService;

    public void execute(String id, UpdateArticleRequest request) {
        Optional<Article> articleOptional = articleService.getArticleById(id);
        if (articleOptional.isEmpty()) {
            throw new ArticleNotFoundException("Article with ID " + id + " not found");
        }
        Article article = articleOptional.get();
        Article updatedArticle = updateArticleFields(article, request);
        articleService.updateArticle(updatedArticle);
    }

    private Article updateArticleFields(Article article, UpdateArticleRequest request) {
        String description = request.getDescription() != null ? request.getDescription() : article.getDescription();
        String model = request.getModel() != null ? request.getModel() : article.getModel();
        return Article.builder()
                .id(article.getId())
                .name(article.getName())
                .description(description)
                .price(article.getPrice())
                .model(model)
                .build();
    }
}
