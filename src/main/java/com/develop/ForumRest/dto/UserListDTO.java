package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.User;

public record UserListDTO(
        Long userId,
        String username,
        String email,
        Status status
) {
    public UserListDTO(User user) {
        this(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getStatus()
        );
    }
}
