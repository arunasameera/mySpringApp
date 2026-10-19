package com.aruna.mySpringApp.service;


import com.aruna.mySpringApp.entity.Student;
import com.aruna.mySpringApp.exception.StudentNotFoundException;
import com.aruna.mySpringApp.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }


    public Student getStudent(Long id){

       return studentRepository.findById(id)
               .orElseThrow(() ->
                       new StudentNotFoundException(
                               "Student not found with id: " + id));

    }

    public Student updateStudent(Long id, Student updatedStudent) {
       Student exsistingStudent = studentRepository.findById(id)
               .orElseThrow(() ->
                       new StudentNotFoundException(
                               "Student not found with id: " + id));

        exsistingStudent.setName(updatedStudent.getName());
        exsistingStudent.setEmail(updatedStudent.getEmail());
        exsistingStudent.setAge(updatedStudent.getAge());


        return studentRepository.save(exsistingStudent);
    }



    @Transactional
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id));

        studentRepository.delete(student);
    }






}
