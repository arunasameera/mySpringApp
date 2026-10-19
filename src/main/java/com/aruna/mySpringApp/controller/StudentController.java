package com.aruna.mySpringApp.controller;

import com.aruna.mySpringApp.entity.Student;
import com.aruna.mySpringApp.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Student Management API",
        description = "REST APIs for managing students"
)
@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(
            summary = "Add student",
            description = "Add a new student to the database"
    )
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student) {

        Student saved = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(
            summary = "Get student by ID",
            description = "Retrieve a student from the database using their ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudent(id);

        return ResponseEntity.ok(student);

    }


    @Operation(
            summary = "Update student",
            description = "Update an existing student in the database"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student updatedStudent){

        Student student = studentService.updateStudent(id,updatedStudent);
        return ResponseEntity.ok(student);

    }


//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentByIdLongVersion(@PathVariable Long id) {
//
//        <Student> optionalStudent  = studentService.getStudent(id);
//
//        if(optionalStudent .isPresent()){
//            Student student =optionalStudent.get();
//            return ResponseEntity.ok(student);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }


    @Operation(
            summary = "Delete student",
            description = "Delete a student from the database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }






}
