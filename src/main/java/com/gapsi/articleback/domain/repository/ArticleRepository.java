package com.gapsi.articleback.domain.repository;

import com.gapsi.articleback.domain.model.Article;

import java.util.Optional;

public interface ArticleRepository {
    Optional<Article> findById(String id);

    Article save(Article article);
}
