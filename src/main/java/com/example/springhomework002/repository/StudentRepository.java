package com.example.springhomework002.repository;

import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
//    @Select("SELECT * from students")
    @Select("SELECT * from students limit #{size} offset (${page}-1) ")
    @Result(property = "studentCourses", column = "student_id",many = @Many(select = "com.example.springhomework002.repository.CourseRepository.getAllCourses"))
    List<Students> getAllStudent(Integer page , Integer size);
    @Select("SELECT * from students where student_id=#{id}")
    @Result(property = "studentCourses", column = "student_id",many = @Many(select = "com.example.springhomework002.repository.CourseRepository.getAllCourses"))
    Students getStudentById(Integer id);
    @Select("INSERT INTO students(student_name,email,phone_number) values(#{student_name},#{email},#{phone_number}) returning student_id")
    Integer addStudent(StudentRequest studentRequest);
    @Select("UPDATE students set student_name = #{request.student_name}, email = #{request.email} , phone_number = #{request.phone_number} where student_id=#{id} RETURNING student_id")
    Integer updateStudentById(@Param("request") StudentRequest studentRequest,Integer id);
    @Select("DELETE from students where student_id=${id} returning student_id")
    Integer removeStudent (Integer id);

}
