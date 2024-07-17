package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Status;
import jakarta.validation.constraints.NotNull;

public record RoleUpdateDTO(
        @NotNull
        Long roleId,

        String roleName,

        Status status
) {
}
