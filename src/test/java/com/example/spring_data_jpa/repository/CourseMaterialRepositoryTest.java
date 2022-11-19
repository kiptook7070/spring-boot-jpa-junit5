package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Course;
import com.example.spring_data_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourse(){
        Course course =
                Course.builder()
                .title("Spring Boot")
                .credit("PASS")
                .build();
        courseRepository.save(course);
    }

    @Test
    public void SaveCourseMaterial(){
        Course course =
                Course.builder()
                .title("Spring Boot")
                .credit("PASS")
                .build();
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.emtechhouse.co.ke")
                        .course(course)
                        .build();
        courseMaterialRepository.save(courseMaterial);
    }
}
