package com.develop.ForumRest.service;

import com.develop.ForumRest.dto.CourseCreateDTO;
import com.develop.ForumRest.dto.CourseListDTO;
import com.develop.ForumRest.dto.CourseUpdateDTO;
import com.develop.ForumRest.dto.UserListDTO;
import com.develop.ForumRest.model.*;
import com.develop.ForumRest.repository.CourseRepository;
import com.develop.ForumRest.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public Course createCourse(CourseCreateDTO courseDTO) {
        Set<Tag> tags = courseDTO.tagIds().stream()
                .map(tagId -> tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found")))
                .collect(Collectors.toSet());
        Course course = new Course(courseDTO, tags);
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        return courseOptional.orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(CourseUpdateDTO courseUpdateDTO) {
        Course course = courseRepository.findById(courseUpdateDTO.courseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        if (courseUpdateDTO.courseName() != null) course.setCourseName(courseUpdateDTO.courseName());
        if (courseUpdateDTO.description() != null) course.setDescription(courseUpdateDTO.description());
        if (courseUpdateDTO.tagIds() != null) {
            course.setTags(courseUpdateDTO.tagIds().stream()
                    .map(tagId -> tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found")))
                    .collect(Collectors.toSet()));
        }
        if (courseUpdateDTO.status() != null) course.setStatus(courseUpdateDTO.status());
        return courseRepository.save(course);
    }


    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public void deactivateUser(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setStatus(Status.INACTIVE);
        courseRepository.save(course);
    }

    public Page<CourseListDTO> getAll(Pageable pagination) {
        return courseRepository.findAll(pagination).map(CourseListDTO::new);
    }
}
