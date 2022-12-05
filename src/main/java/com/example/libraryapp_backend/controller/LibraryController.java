package com.example.libraryapp_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @PostMapping("admin")
    public String Adminlogin(){
        return "Welcome to admin login page";
    }

}
