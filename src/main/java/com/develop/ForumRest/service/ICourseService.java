package com.develop.ForumRest.service;


import com.develop.ForumRest.dto.CourseCreateDTO;
import com.develop.ForumRest.dto.CourseUpdateDTO;
import com.develop.ForumRest.model.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(CourseCreateDTO courseDTO);
    Course getCourseById(Long courseId);
    List<Course> getAllCourses();
    Course updateCourse(CourseUpdateDTO courseUpdateDTO);
    void deleteCourse(Long courseId);
    void deactivateUser(Long courseId);

}
