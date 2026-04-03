package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String add() {
        return "Added by ADMIN";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Deleted by ADMIN";
    }
}