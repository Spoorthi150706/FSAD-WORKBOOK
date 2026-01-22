package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 201;
    private String name = "Full Stack";
    private String dateOfCompletion = "10-01-2026";

    public void display() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Date: " + dateOfCompletion);
    }
}
