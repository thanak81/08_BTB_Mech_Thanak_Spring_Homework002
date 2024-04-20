package com.example.springhomework002.service;


import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Courses> getAllCourse();
    Courses getCourseById(Integer id);

    Integer addCourse(CourseRequest courseRequest);
    Integer updateCourseById(CourseRequest courseRequest,Integer course_id);
Integer removeCourseById(Integer id);
}
