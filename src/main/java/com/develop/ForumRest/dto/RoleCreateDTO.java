package com.develop.ForumRest.dto;

import jakarta.validation.constraints.NotBlank;

public record RoleCreateDTO(
        @NotBlank
        String roleName
) {
}
