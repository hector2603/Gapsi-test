package com.gapsi.articleback.domain.model;

import com.gapsi.articleback.infrastructure.persistence.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class Article {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String model;

    public ArticleEntity toEntity() {
        return ArticleEntity.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .model(model)
                .build();
    }
}
