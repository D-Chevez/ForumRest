package com.develop.ForumRest.controller;

import com.develop.ForumRest.dto.*;
import com.develop.ForumRest.model.Course;
import com.develop.ForumRest.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //READE
    @GetMapping
    public ResponseEntity<Page<CourseListDTO>> getCourses(@PageableDefault(size = 5) Pageable pagination) {
        Page<CourseListDTO> courses = courseService.getAll(pagination);
        return ResponseEntity.ok(courses);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping
    public ResponseEntity<CourseDetailDTO> createCourse(@RequestBody @Valid CourseCreateDTO courseCreateDTO, UriComponentsBuilder uriComponentsBuilder) {
        Course course = courseService.createCourse(courseCreateDTO);
        CourseDetailDTO courseDetail = new CourseDetailDTO(course);
        URI uri = uriComponentsBuilder.path("/courses/{id}").buildAndExpand(courseDetail.courseId()).toUri();
        return ResponseEntity.created(uri).body(courseDetail);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDetailDTO> updateCourse(@RequestBody @Valid CourseUpdateDTO courseUpdateDTO, UriComponentsBuilder uriComponentsBuilder) {
        Course courseUpdate = courseService.updateCourse(courseUpdateDTO);
        CourseDetailDTO courseDetailDTO = new CourseDetailDTO(courseUpdate);
        return ResponseEntity.ok(courseDetailDTO);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateCourse(@PathVariable Long id) {
        courseService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDTO> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        CourseDetailDTO courseDetailDTO = new CourseDetailDTO(course);
        return ResponseEntity.ok(courseDetailDTO);
    }
}
