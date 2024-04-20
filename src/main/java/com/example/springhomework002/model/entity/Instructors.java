package com.example.springhomework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Instructors {
    private Integer instructor_id;
    private String instructor_name;
    private String email;
}
