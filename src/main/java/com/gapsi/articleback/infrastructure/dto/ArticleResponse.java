package com.gapsi.articleback.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private String model;
}
