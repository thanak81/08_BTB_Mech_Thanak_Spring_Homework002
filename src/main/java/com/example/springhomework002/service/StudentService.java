package com.example.springhomework002.service;

import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudent(Integer page, Integer size);
    Students getStudentById(Integer id);
    Integer addStudent(StudentRequest studentRequest);
    Integer updateStudentByID(StudentRequest studentRequest,Integer id);
    Integer removeStudent(Integer id);

}
