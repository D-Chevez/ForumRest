package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Role;

public record RoleListDTO(
        String roleName
) {
    public RoleListDTO(Role role){
        this(
            role.getRoleName()
        );
    }
}
