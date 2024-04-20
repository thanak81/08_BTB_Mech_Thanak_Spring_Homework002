package com.example.springhomework002.repository;

import com.example.springhomework002.model.entity.Student_Course;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCourseRepository {
    @Select("SELECT * from student_course ")
    @Result(property = "instructors" , column = "instructor_id"
            , one =  @One(select = "com.example.springhomework002.repository.InstructorsRepository.getInstructorById"))

    List<Student_Course> student_course();

}
