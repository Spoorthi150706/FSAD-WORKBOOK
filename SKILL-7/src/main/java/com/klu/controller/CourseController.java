package com.klu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course saved = service.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Long id) {
        Optional<Course> course = service.getCourseById(id);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        if (service.getCourseById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }
        Course updated = service.updateCourse(id, course);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        if (service.getCourseById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }
        service.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchByTitle(@PathVariable String title) {
        List<Course> courses = service.searchByTitle(title);
        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No courses found with this title");
        }
        return ResponseEntity.ok(courses);
    }
}