package com.gapsi.articleback.infrastructure.dto;

import lombok.Data;

import java.util.Map;

@Data
public class BaseResponse {
    private ArticleResponse article;
    private String message;
    private String code;
    private Map<String, String> errors;

    public static BaseResponse of(ArticleResponse article) {
        BaseResponse response = new BaseResponse();
        response.setArticle(article);
        return response;
    }
}
