package com.gapsi.articleback.infrastructure.controller;

import com.gapsi.articleback.application.usecase.GetArticleDetailsUseCase;
import com.gapsi.articleback.application.usecase.UpdateArticleDetailsUseCase;
import com.gapsi.articleback.infrastructure.dto.ArticleResponse;
import com.gapsi.articleback.infrastructure.dto.UpdateArticleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@Tag(name = "Articles", description = "API for managing articles")
public class ArticleController {

    @Autowired
    private GetArticleDetailsUseCase getArticleDetailsUseCase;

    @Autowired
    private UpdateArticleDetailsUseCase updateArticleDetailsUseCase;

    @Operation(summary = "Get article details", description = "Returns the details of an article by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(
            @Parameter(description = "ID of the article to retrieve", required = true)
            @PathVariable String id) {
        ArticleResponse article = getArticleDetailsUseCase.execute(id);
        return ResponseEntity.ok(article);
    }

    @Operation(summary = "Update article details", description = "Partially updates the details of the article, such as description and model.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Article updated successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateArticle(
            @Parameter(description = "ID of the article to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Object containing the fields to update", required = true)
            @RequestBody UpdateArticleRequest request) {
        updateArticleDetailsUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }
}