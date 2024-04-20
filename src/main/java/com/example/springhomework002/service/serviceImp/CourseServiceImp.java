package com.example.springhomework002.service.serviceImp;

import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.model.request.CourseRequest;
import com.example.springhomework002.repository.CourseRepository;
import com.example.springhomework002.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    @Override
    public List<Courses> getAllCourse() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Courses getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Integer addCourse(CourseRequest courseRequest) {
        return courseRepository.addCourse(courseRequest);
    }

    @Override
    public Integer updateCourseById(CourseRequest courseRequest, Integer course_id) {
        return courseRepository.updateCourse(courseRequest,course_id);
    }

    @Override
    public Integer removeCourseById(Integer id) {
        return courseRepository.removeCourseById(id);
    }


}
