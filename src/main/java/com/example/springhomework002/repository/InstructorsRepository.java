package com.example.springhomework002.repository;

import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InstructorsRepository {
    @Select("SELECT * from instructors")
    List<Instructors> getAllInstructor();
    @Select("SELECT * from instructors where instructor_id = #{id}")
    Instructors getInstructorById(Integer id);
    @Select("INSERT INTO instructors(instructor_name, email) values (#{instructor_name},#{email}) returning instructor_id")
    Integer addInstructor(InstructorRequest instructorRequest);
    @Select("UPDATE instructors set instructor_name = #{request.instructor_name},email = #{request.email} where instructor_id = #{id} returning instructor_id")
    Integer updateInstructorById(@Param("request") InstructorRequest instructorRequest, Integer id);
    @Select("DELETE from instructors where instructor_id = #{id} returning instructor_id")
    Integer removeInstructorById(Integer id);
}
