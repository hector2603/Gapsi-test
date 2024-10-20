package com.gapsi.articleback.infrastructure.config;

import com.gapsi.articleback.infrastructure.dto.BaseResponse;
import com.gapsi.articleback.shared.exception.ArticleNotFoundException;
import com.gapsi.articleback.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<BaseResponse> handleArticleNotFoundException(ArticleNotFoundException ex) {
        BaseResponse response = new BaseResponse();
        response.setMessage(ErrorCodes.NOT_FOUND.getMessage());
        response.setCode(ErrorCodes.NOT_FOUND.getCode());
        Map<String, String> errors = new HashMap<>();
        errors.put(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        response.setErrors(errors);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BaseResponse response = new BaseResponse();
        response.setMessage(ErrorCodes.BAD_REQUEST.getMessage());
        response.setCode(ErrorCodes.BAD_REQUEST.getCode());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        response.setErrors(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleGeneralException(Exception ex) {
        BaseResponse response = new BaseResponse();
        response.setMessage(ErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        response.setCode(ErrorCodes.INTERNAL_SERVER_ERROR.getCode());
        Map<String, String> errors = new HashMap<>();
        errors.put(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        response.setErrors(errors);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}