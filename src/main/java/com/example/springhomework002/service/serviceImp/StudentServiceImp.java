package com.example.springhomework002.service.serviceImp;

import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.model.request.StudentRequest;
import com.example.springhomework002.repository.StudentRepository;
import com.example.springhomework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // business logic
public class StudentServiceImp  implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudent(Integer page, Integer size) {
        return studentRepository.getAllStudent(page,size);
    }

    @Override
    public  Students getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Integer addStudent(StudentRequest studentRequest) {
        return studentRepository.addStudent(studentRequest);
    }

    @Override
    public Integer updateStudentByID(StudentRequest studentRequest,Integer id) {
        return studentRepository.updateStudentById(studentRequest,id);
    }

    @Override
    public Integer removeStudent(Integer id) {
        return studentRepository.removeStudent(id);
    }


}
