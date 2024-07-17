package com.develop.ForumRest.dto;

import com.develop.ForumRest.model.Course;
import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.Tag;

import java.util.Set;
import java.util.stream.Collectors;

public record CourseListDTO(
        Long courseId,
        String courseName,
        String description,
        Set<Long> tagIds,
        Status status
) {
    public CourseListDTO(Course course) {
        this(
                course.getCourseId(),
                course.getCourseName(),
                course.getDescription(),
                course.getTags().stream().map(Tag::getTagId).collect(Collectors.toSet()),
                course.getStatus()
        );
    }
}
