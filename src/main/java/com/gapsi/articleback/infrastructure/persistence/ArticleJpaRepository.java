package com.gapsi.articleback.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String> {
}
