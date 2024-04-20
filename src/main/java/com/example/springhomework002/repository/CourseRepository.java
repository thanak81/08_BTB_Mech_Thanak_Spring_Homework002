package com.example.springhomework002.repository;

import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("SELECT * from courses")
    @Result(property = "instructors",column = "instructor_id"
    ,one =  @One(select = "com.example.springhomework002.repository.InstructorsRepository.getInstructorById")
    )
    List<Courses> getAllCourses();
    @Select("SELECT * from courses where course_id = #{id}")
    @Result(property = "instructors",column = "instructor_id"
            ,one =  @One(select = "com.example.springhomework002.repository.InstructorsRepository.getInstructorById")
    )
    Courses getCourseById(Integer id);

    @Select("INSERT INTO courses(course_name, description,instructor_id) VALUES (#{course_name},#{description},#{instructor_id}) returning course_id")
    Integer addCourse( CourseRequest coursesRequest);

    @Select("UPDATE courses set course_name= #{request.course_name} , description = #{request.description}, instructor_id= #{request.instructor_id} where course_id=#{id} returning course_id")
    Integer updateCourse(@Param("request") CourseRequest courseRequest, Integer id);

    @Select("DELETE FROM courses where course_id= #{id} returning course_id" )
    Integer removeCourseById(Integer id);

}
