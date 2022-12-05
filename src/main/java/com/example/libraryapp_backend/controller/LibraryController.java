package com.example.libraryapp_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @PostMapping("admin")
    public String Adminlogin(){
        return "Welcome to admin login page";
    }
    @PostMapping("user")
    public String Userlogin(){
        return "welcome to user login page";
    }
    @PostMapping("reg")
    public String Userreg(){
        return "welcome to user registration";
    }
    @PostMapping("add")
    public String Bookadd(){
        return "welcome to book add page";
    }
    @PostMapping("search")
    public String Booksearch(){
        return "welcome to book search page";
    }
}
