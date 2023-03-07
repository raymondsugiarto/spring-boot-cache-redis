package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
//  private final RedisCacheManager cacheManager;

  @Cacheable(value="student1", key="#id")
  public Student getStudentById(Long id) {
    return studentRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  public Student createStudent() {
    return studentRepository.save(Student.builder().name("budi").build());
  }


  @Cacheable(value = "itemCache", key = "#id")
  public Student getStudentManual(Long id) {
    return Student.builder().id(1L).name("Ani").build();
  }
}
