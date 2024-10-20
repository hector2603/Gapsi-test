package com.gapsi.articleback.infrastructure.controller;

import com.gapsi.articleback.application.usecase.GetArticleDetailsUseCase;
import com.gapsi.articleback.application.usecase.UpdateArticleDetailsUseCase;
import com.gapsi.articleback.infrastructure.dto.ArticleResponse;
import com.gapsi.articleback.infrastructure.dto.BaseResponse;
import com.gapsi.articleback.infrastructure.dto.UpdateArticleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
            @ApiResponse(responseCode = "200", description = "Article found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseResponse.class),
                            examples = @ExampleObject(
                                    name = "Success Example",
                                    summary = "Example of successful response",
                                    value = "{\n" +
                                            "  \"article\": {\n" +
                                            "    \"id\": \"A12345B678\",\n" +
                                            "    \"name\": \"Laptop\",\n" +
                                            "    \"description\": \"A high-performance laptop for coding and gaming.\",\n" +
                                            "    \"price\": 1200.5,\n" +
                                            "    \"model\": \"Model-X1\"\n" +
                                            "  },\n" +
                                            "  \"message\": null,\n" +
                                            "  \"code\": null,\n" +
                                            "  \"errors\": null\n" +
                                            "}"))),
            @ApiResponse(responseCode = "404", description = "Article not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Error Example",
                                    summary = "Example of 404 error response",
                                    value = "{\n" +
                                            "  \"message\": \"Not Found\",\n" +
                                            "  \"code\": \"ERR-404\",\n" +
                                            "  \"errors\": {\n" +
                                            "    \"404 NOT_FOUND\": \"Article with ID A12345B67 not found\"\n" +
                                            "  }\n" +
                                            "}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Internal Server Error Example",
                                    summary = "Example of 500 error response",
                                    value = "{\n" +
                                            "  \"article\": null,\n" +
                                            "  \"message\": \"Internal Server Error\",\n" +
                                            "  \"code\": \"ERR-500\",\n" +
                                            "  \"errors\": {\n" +
                                            "    \"500 INTERNAL_SERVER_ERROR\": \"Could not open JPA EntityManager for transaction\"\n" +
                                            "  }\n" +
                                            "}")))
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getArticleById(
            @Parameter(description = "ID of the article, must be alphanumeric and 10 characters long", required = true)
            @PathVariable
            @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid ID, only alphanumeric characters are allowed")
            @Size(min = 10, max = 10, message = "Invalid ID, must be exactly 10 characters long")
            String id) {
        ArticleResponse article = getArticleDetailsUseCase.execute(id);
        return ResponseEntity.ok(BaseResponse.of(article));
    }

    @Operation(summary = "Update article details", description = "Partially updates the details of the article, such as description and model.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Article updated successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Article not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Error Example",
                                    summary = "Example of 404 error response",
                                    value = "{\n" +
                                            "  \"message\": \"Not Found\",\n" +
                                            "  \"code\": \"ERR-404\",\n" +
                                            "  \"errors\": {\n" +
                                            "    \"404 NOT_FOUND\": \"Article with ID A12345B67 not found\"\n" +
                                            "  }\n" +
                                            "}"))),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Bad Request Example",
                                    summary = "Example of 400 Bad Request",
                                    value = "{\n" +
                                            "  \"article\": null,\n" +
                                            "  \"message\": \"Invalid Request\",\n" +
                                            "  \"code\": \"ERR-400\",\n" +
                                            "  \"errors\": {\n" +
                                            "    \"description\": \"description cannot be blank\",\n" +
                                            "    \"model\": \"model cannot exceed 10 characters\"\n" +
                                            "  }\n" +
                                            "}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Internal Server Error Example",
                                    summary = "Example of 500 error response",
                                    value = "{\n" +
                                            "  \"article\": null,\n" +
                                            "  \"message\": \"Internal Server Error\",\n" +
                                            "  \"code\": \"ERR-500\",\n" +
                                            "  \"errors\": {\n" +
                                            "    \"500 INTERNAL_SERVER_ERROR\": \"Could not open JPA EntityManager for transaction\"\n" +
                                            "  }\n" +
                                            "}")))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateArticle(
            @Parameter(description = "ID of the article, must be alphanumeric and 10 characters long", required = true)
            @PathVariable
            @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid ID, only alphanumeric characters are allowed")
            @Size(min = 10, max = 10, message = "Invalid ID, must be exactly 10 characters long")
            String id,
            @Parameter(description = "Object containing the fields to update", required = true)
            @RequestBody
            @Valid UpdateArticleRequest request) {
        updateArticleDetailsUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }
}