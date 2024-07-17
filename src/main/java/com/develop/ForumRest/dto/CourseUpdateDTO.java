package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Status;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CourseUpdateDTO(
        @NotNull Long courseId,
        String courseName,
        String description,
        Set<Long> tagIds,
        Status status
) {}
