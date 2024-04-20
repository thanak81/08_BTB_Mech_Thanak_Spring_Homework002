package com.example.springhomework002.service;

import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.model.request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    List<Instructors> getAllInstructor();
    Instructors getInstructorById(Integer id);
    Integer addInstructor(InstructorRequest instructorRequest);
    Integer updateInstructorById(InstructorRequest instructorRequest,Integer id);
    Integer removeInstructor(Integer id);
}
