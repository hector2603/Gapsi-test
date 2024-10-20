package com.gapsi.articleback.shared.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
