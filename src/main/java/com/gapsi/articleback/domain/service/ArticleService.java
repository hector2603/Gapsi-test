package com.gapsi.articleback.domain.service;

import com.gapsi.articleback.domain.model.Article;
import com.gapsi.articleback.domain.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticleById(String id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

}
