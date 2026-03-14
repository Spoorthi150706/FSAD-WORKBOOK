package com.klu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2. Count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3. Price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. List of books
    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "Data Structures");
    }

    // 5. Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. Search using request param
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book titled: " + title;
    }

    // 7. Author
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. Add Book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. View all books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
