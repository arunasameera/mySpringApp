package com.aruna.mySpringApp.repository;

import com.aruna.mySpringApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {
}
