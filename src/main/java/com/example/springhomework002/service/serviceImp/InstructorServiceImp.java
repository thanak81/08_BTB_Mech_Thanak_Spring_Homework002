package com.example.springhomework002.service.serviceImp;

import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.model.request.InstructorRequest;
import com.example.springhomework002.repository.InstructorsRepository;
import com.example.springhomework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {
    private final InstructorsRepository instructorsRepository;

    public InstructorServiceImp(InstructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }

    @Override
    public List<Instructors> getAllInstructor() {
        return instructorsRepository.getAllInstructor();
    }

    @Override
    public Instructors getInstructorById(Integer id) {
        return instructorsRepository.getInstructorById(id);
    }

    @Override
    public Integer addInstructor(InstructorRequest instructorRequest) {
        return instructorsRepository.addInstructor(instructorRequest);
    }


    @Override
    public Integer updateInstructorById(InstructorRequest instructorRequest, Integer id) {
        return instructorsRepository.updateInstructorById(instructorRequest,id);
    }

    @Override
    public Integer removeInstructor(Integer id) {
        return instructorsRepository.removeInstructorById(id);
    }
}
