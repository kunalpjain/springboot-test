package com.example.demo.dto;

import lombok.Data;

@Data
public class CreateStudentRequest {
    private String name;
    private String courseName;
    private String universityName;
}
