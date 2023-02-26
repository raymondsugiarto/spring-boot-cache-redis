package com.raymondsugiarto.springbootcacheredis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raymond on 26/02/23
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
