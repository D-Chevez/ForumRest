package com.develop.ForumRest.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record CourseCreateDTO(
        @NotBlank String courseName,
        String description,
        Set<Long> tagIds
) {}
