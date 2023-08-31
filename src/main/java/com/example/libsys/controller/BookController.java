package com.example.libsys.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping("/public")
    public ResponseEntity<String> getBooks(){
        return ResponseEntity.ok("All Books.");
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> getUserBooks() {
        return ResponseEntity.ok("These books are accessible to users with ROLE_USER.");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> getAdminBooks() {
        return ResponseEntity.ok("These books are accessible to users with ROLE_ADMIN.");
    }

}
