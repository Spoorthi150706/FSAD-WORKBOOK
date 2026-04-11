package com.klu.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Student Model")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Schema(description = "Student ID", example = "1")
    private Long id;

    @Schema(description = "Student Name", example = "Spoorthi")
    private String name;

    @Schema(description = "Student Email", example = "spoorthi@gmail.com")
    private String email;

    @Schema(description = "Course", example = "CSE")
    private String course;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}