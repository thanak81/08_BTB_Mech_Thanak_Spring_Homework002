package com.example.springhomework002.controller;

import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.model.request.InstructorRequest;
import com.example.springhomework002.model.response.APIResponse;
import com.example.springhomework002.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/")
    public ResponseEntity<?> getAllInstructor(){
        APIResponse<List<Instructors>> response;
        if(!instructorService.getAllInstructor().isEmpty()){
            response = APIResponse.<List<Instructors>>builder()
                    .message("Instructor List retrieve")
                    .status(HttpStatus.FOUND)
                    .payload(instructorService.getAllInstructor())
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<List<Instructors>>builder()
                    .message("Instructors list not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
            return ResponseEntity.ok(response);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer id){
        APIResponse<Instructors> response;
        Instructors instructorId = instructorService.getInstructorById(id);
        if(instructorId != null){
            response = APIResponse.<Instructors>builder()
                    .message("Instructor List retrieve")
                    .status(HttpStatus.FOUND)
                    .payload(instructorService.getInstructorById(id))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Instructors>builder()
                    .message("Instructor " + id +" Not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/addInstructor")
    public ResponseEntity<?> addInstructor(@RequestBody InstructorRequest instructorRequest){
        Integer instructorID = instructorService.addInstructor(instructorRequest);
        System.out.println(instructorID);
        APIResponse<Instructors> response = APIResponse.<Instructors>builder()
                .message("Instructor Created")
                .status(HttpStatus.FOUND)
                .payload(instructorService.getInstructorById(instructorID))
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return  ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInstructorById(@RequestBody InstructorRequest instructorRequest,@PathVariable Integer id ){
        APIResponse<Instructors> response ;
        Integer instructorId= instructorService.updateInstructorById(instructorRequest,id);
        if(instructorId != null){
            response = APIResponse.<Instructors>builder()
                    .message("Instructor " + id+ " is successfully created")
                    .status(HttpStatus.FOUND)
                    .payload(instructorService.getInstructorById(instructorId))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Instructors>builder()
                    .message("Instructor" + id +" Not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeIntructorById(@PathVariable Integer id){
        APIResponse<Instructors> response;
        Integer instructorId = instructorService.removeInstructor(id);
        if(instructorId != null){
            response = APIResponse.<Instructors>builder()
                    .message("Instructor "+ id +" is successfully removed")
                    .status(HttpStatus.FOUND)
                    .payload(instructorService.getInstructorById(instructorId))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Instructors>builder()
                    .message("Instructor " + id +" Not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }
}
