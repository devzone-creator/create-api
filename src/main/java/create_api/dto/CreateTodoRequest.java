package create_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTodoRequest(
    @NotBlank(message = "Title is required") String title, String description)
{}