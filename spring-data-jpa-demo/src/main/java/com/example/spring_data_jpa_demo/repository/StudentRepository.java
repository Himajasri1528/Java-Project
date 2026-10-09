package com.example.spring_data_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_data_jpa_demo.entity.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

}
