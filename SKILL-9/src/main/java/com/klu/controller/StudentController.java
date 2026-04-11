package com.klu.controller;

import com.klu.exception.*;
import com.klu.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController
{
    List<Student> list = Arrays.asList(
            new Student(1,"Ravi",80),
            new Student(2,"Sita",90),
            new Student(3,"Kiran",75)
    );

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id)
    {
        int sid;

        try
        {
            sid = Integer.parseInt(id);
        }
        catch(Exception e)
        {
            throw new InvalidInputException("Student ID must be a number");
        }

        return list.stream()
                .filter(s -> s.getId()==sid)
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID : "+sid)
                );
    }
}