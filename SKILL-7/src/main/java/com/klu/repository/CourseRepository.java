package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.klu.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContainingIgnoreCase(String title);
}