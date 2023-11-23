package com.example.demo.service;

import com.example.demo.dto.CreateStudentRequest;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final UniversityRepository universityRepository;

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Course addedCourse = courseRepository.save(new Course(
                createStudentRequest.getCourseName()
        ));

        Optional<University> university = universityRepository.findByName(createStudentRequest.getUniversityName());
        if (!university.isPresent()) {
            return null;
        }

        return studentRepository.save(new Student(
                createStudentRequest.getName(),
                addedCourse,
                university.get()
        ));
    }
}
