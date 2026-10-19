package com.aruna.mySpringApp.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Student full name", example = "Aruna")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(
            description = "Student email address",
            example = "aruna@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(
            description = "Student age",
            example = "25",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be greater than zero")
    private Integer age;


    public Student() {
    }


}
