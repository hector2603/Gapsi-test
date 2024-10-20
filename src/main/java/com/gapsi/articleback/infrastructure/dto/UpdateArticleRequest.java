package com.gapsi.articleback.infrastructure.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
@Data
@Builder
public class UpdateArticleRequest {

    @Size(max = 200, message = "Description cannot exceed 200 characters")
    @NotBlank(message = "description cannot be blank")
    private String description;

    @Size(max = 10, message = "model cannot exceed 10 characters")
    @NotBlank(message = "model cannot be blank")
    private String model;

}
