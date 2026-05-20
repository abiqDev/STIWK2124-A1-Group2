package com.arl.reading_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arl.reading_list.entity.Book;
import com.arl.reading_list.service.BookService;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired private BookService service;

    @GetMapping
    public ResponseEntity<?> list(
        @RequestParam(defaultValue = "") String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        Page<Book> result = q.isBlank()
            ? service.getAll(page, size)
            : service.search(q, page, size);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Book book) {
        return ResponseEntity.status(201).body("Book created successfully: " + service.create(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Book book) {
        book.setId(id);
        return ResponseEntity.ok("Book updated successfully: " + service.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Book with ID " + id + " deleted successfully!");
    }
}

    

