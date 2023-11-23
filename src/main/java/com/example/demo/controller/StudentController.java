package com.example.demo.controller;

import com.example.demo.dto.CreateStudentRequest;
import com.example.demo.dto.CreateStudentResponse;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return Optional.ofNullable(studentService.createStudent(createStudentRequest).getId())
                .map(CreateStudentResponse::new)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Student could not be created"));
    }
}
