package com.example.demo.service;

import com.example.demo.dto.CreateStudentRequest;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Course addedCourse = courseRepository.save(new Course(
                createStudentRequest.getCourseName()
        ));

        return studentRepository.save(new Student(
                createStudentRequest.getName(),
                addedCourse
        ));
    }
}
