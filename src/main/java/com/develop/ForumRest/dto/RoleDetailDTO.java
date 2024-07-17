package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Role;
import com.develop.ForumRest.model.Status;

public record RoleDetailDTO(
        Long roleId,
        String roleName,
        Status status
) {
    public RoleDetailDTO(Role role) {
        this(
                role.getRoleId(),
                role.getRoleName(),
                role.getStatus()
        );
    }
}
