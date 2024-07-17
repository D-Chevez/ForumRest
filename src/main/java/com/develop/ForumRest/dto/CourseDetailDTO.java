package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Course;
import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.Tag;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record CourseDetailDTO(
        Long courseId,
        String courseName,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Set<Long> tagIds,
        Status status
) {
    public CourseDetailDTO(Course course) {
        this(
                course.getCourseId(),
                course.getCourseName(),
                course.getDescription(),
                course.getCreatedAt(),
                course.getUpdatedAt(),
                course.getTags().stream().map(Tag::getTagId).collect(Collectors.toSet()),
                course.getStatus()
        );
    }
}
