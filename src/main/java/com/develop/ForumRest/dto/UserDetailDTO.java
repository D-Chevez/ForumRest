package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.User;

import java.time.LocalDateTime;

public record UserDetailDTO(
        Long userId,
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long roleId,
        Status status
){
    public UserDetailDTO(User user) {
        this(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getRole().getRoleId(),
                user.getStatus()
        );
    }
}
