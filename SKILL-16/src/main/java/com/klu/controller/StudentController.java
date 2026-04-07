package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Add a new student")
    @ApiResponse(responseCode = "200", description = "Student added successfully")
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.save(s);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Get student by ID")
    @ApiResponse(responseCode = "404", description = "Student not found")
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}