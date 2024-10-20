package com.gapsi.articleback.application.usecase;

import com.gapsi.articleback.infrastructure.dto.ArticleResponse;
import org.springframework.stereotype.Component;

@Component
public class GetArticleDetailsUseCase {
    public ArticleResponse execute(String id) {
        return ArticleResponse.builder()
                .id(id)
                .name("Article Name")
                .description("Article Description")
                .price(100.0)
                .model("Article Model")
                .build();
    }
}
