package com.example.demo.dto;

import lombok.Data;

@Data
public class CreateStudentResponse {
    private long id;

    public CreateStudentResponse(long id) {
        this.id = id;
    }
}
