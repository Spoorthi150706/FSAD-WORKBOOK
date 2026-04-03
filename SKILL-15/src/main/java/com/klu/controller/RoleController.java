package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")   // ✅ FIXED
public class RoleController {

    @GetMapping("/add")
    public String add() {
        return "Admin added successfully";
    }

    @GetMapping("/delete")
    public String delete() {
        return "Admin deleted successfully";
    }
}