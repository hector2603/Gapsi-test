package com.gapsi.articleback.infrastructure.persistence;

import com.gapsi.articleback.domain.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name = "articles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {

    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String model;

    public Article toModel() {
        return Article.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .model(model)
                .build();
    }
}