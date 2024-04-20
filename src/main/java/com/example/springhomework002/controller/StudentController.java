package com.example.springhomework002.controller;

import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.model.request.StudentRequest;
import com.example.springhomework002.model.response.APIResponse;
import com.example.springhomework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer size){
        APIResponse<List<Students>> response;
        if(!studentService.getAllStudent(page, size).isEmpty()){
            response = APIResponse.<List<Students>>builder()
                    .message("Student lists retrieve")
                    .payload(studentService.getAllStudent(page,size))
                    .status(HttpStatus.FOUND)
                     .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<List<Students>>builder()
                    .message("There are no students")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        APIResponse<Students> response ;
        Students studentID =studentService.getStudentById(id);
        if(studentID != null){
            response= APIResponse.<Students>builder()
                    .message("Student "+ id + " is retrieve")
                    .payload(studentService.getStudentById(id))
                    .status(HttpStatus.FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        else {
            response = APIResponse.<Students>builder()
                    .message("Student "+ id + " is not found")
            .status(HttpStatus.NOT_FOUND)
            .timestamp(new Timestamp(System.currentTimeMillis())).build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest){
        Integer studentID = studentService.addStudent(studentRequest);
        APIResponse<Students> response = APIResponse.<Students>builder()
                .message("Student is successfully added")
                .payload(studentService.getStudentById(studentID))
                .status(HttpStatus.CREATED)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@RequestBody StudentRequest studentRequest,@PathVariable Integer id){
        APIResponse<Students> response;
        Integer studentID = studentService.updateStudentByID(studentRequest,id);
        System.out.println(studentID);
        if(studentID != null){
            response = APIResponse.<Students>builder()
                    .message("Student is successfully updated")
                    .payload(studentService.getStudentById(studentID))
                    .status(HttpStatus.FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else {
            response = APIResponse.<Students>builder()
                    .message("Student "+ id + " not found")
                    .status(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Integer id){
        APIResponse<Students> response;
        Integer studentId = studentService.removeStudent(id);
            if(studentId != null){
            response = APIResponse.<Students>builder()
                    .message("Student is successfully removed")
                    .payload(studentService.getStudentById(id))
                    .status(HttpStatus.FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Students>builder()
                    .message("Student "+ id + " not found")
                    .status(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }

        return ResponseEntity.ok(response);
    }
}
