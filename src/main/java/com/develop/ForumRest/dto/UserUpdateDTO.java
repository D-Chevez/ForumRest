package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long userId,

        String username,

        String email,

        String password,

        Long roleId,

        Status status
) {
}
