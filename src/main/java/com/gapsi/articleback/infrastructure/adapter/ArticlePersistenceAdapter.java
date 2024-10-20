package com.gapsi.articleback.infrastructure.adapter;

import com.gapsi.articleback.domain.model.Article;
import com.gapsi.articleback.domain.repository.ArticleRepository;
import com.gapsi.articleback.infrastructure.persistence.ArticleEntity;
import com.gapsi.articleback.infrastructure.persistence.ArticleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArticlePersistenceAdapter implements ArticleRepository {

    @Autowired
    private ArticleJpaRepository articleJpaRepository;

    @Override
    public Optional<Article> findById(String id) {
        return articleJpaRepository.findById(id).map(ArticleEntity::toModel);
    }

    @Override
    public Article save(Article article) {
        return articleJpaRepository.save(article.toEntity()).toModel();
    }
}
