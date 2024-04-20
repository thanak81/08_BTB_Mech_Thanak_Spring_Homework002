package com.example.springhomework002.controller;

import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.model.request.CourseRequest;
import com.example.springhomework002.model.response.APIResponse;
import com.example.springhomework002.service.CourseService;
import com.example.springhomework002.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    private final InstructorService instructorService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCourse(){
        APIResponse<List<Courses>> response;
        if(!courseService.getAllCourse().isEmpty()){
            response = APIResponse.<List<Courses>>builder()
                    .message("Courses List retrieve")
                    .status(HttpStatus.FOUND)
                    .payload(courseService.getAllCourse())
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<List<Courses>>builder()
                    .message("Courses List not exist")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        APIResponse<Courses> response;
        Courses courseId = courseService.getCourseById(id);
        if(courseId != null){
            response = APIResponse.<Courses>builder()
                    .message("Course "+ id + " is retrieve")
                    .status(HttpStatus.FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .payload(courseService.getCourseById(id)).build();
        }else{
            response = APIResponse.<Courses>builder()
                    .message("Course "+ id + " is not found")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest courseRequest){
        APIResponse<Courses> response;

        if(instructorService.getInstructorById(courseRequest.getInstructor_id()) != null){
            response = APIResponse.<Courses>builder()
                    .message("Course is successfully created")
                    .status(HttpStatus.FOUND)
                    .payload(courseService.getCourseById(courseService.addCourse(courseRequest)))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Courses>builder()
                    .message("Instructor ID not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("updateCourse/{id}")
    public ResponseEntity<?> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Integer id){
        APIResponse<Courses> response;
        Integer courseId = courseService.updateCourseById(courseRequest,id);

        if(instructorService.getInstructorById(courseRequest.getInstructor_id()) == null){
            response = APIResponse.<Courses>builder()
                    .message("Instructor ID not found")
                    .status(HttpStatus.FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
            if(courseId!= null){
                response = APIResponse.<Courses>builder()
                        .message("Course "+ courseId +" is successfully updated")
                        .status(HttpStatus.FOUND)
                        .payload(courseService.getCourseById(id))
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build();
            }else{
                response = APIResponse.<Courses>builder()
                        .message("Instructor not found")
                        .status(HttpStatus.NOT_FOUND)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build();
                return ResponseEntity.ok(response);
            }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeCourseById(@PathVariable Integer id){
        APIResponse<Courses> response;
        Integer courseId = courseService.removeCourseById(id);
        System.out.println(courseId);
        if(courseId != null){
            response = APIResponse.<Courses>builder()
                    .message("Course "+ id +" is successfully removed")
                    .status(HttpStatus.FOUND)
                    .payload(courseService.getCourseById(courseId))
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = APIResponse.<Courses>builder()
                    .message("Course " + id +" Not found")
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }
}
