package com.example.springhomework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Courses {
    private int course_id;
    private String course_name;
    private String description;

    private Instructors instructors;
}
