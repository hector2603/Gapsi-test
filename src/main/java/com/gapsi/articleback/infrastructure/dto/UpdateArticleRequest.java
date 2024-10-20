package com.gapsi.articleback.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateArticleRequest {
    private String description;
    private String model;
}
