package com.raymondsugiarto.springbootcacheredis;

import io.lettuce.core.RedisCommandTimeoutException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raymond on 26/02/23
 */
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public Student createStudent() {
        return studentService.createStudent();
    }

    @GetMapping("/student")
    public Student getStudent() {
        return studentService.getStudentById(1L);
    }

}
