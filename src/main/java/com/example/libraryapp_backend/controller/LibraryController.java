package com.example.libraryapp_backend.controller;

import com.example.libraryapp_backend.dao.BookDao;
import com.example.libraryapp_backend.dao.RegistrationDao;
import com.example.libraryapp_backend.model.Books;
import com.example.libraryapp_backend.model.Registration;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    private BookDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> BookAdd(@RequestBody Books l)
    {
        System.out.println(l.getTitle().toString());
        System.out.println(l.getAuthor().toString());
        System.out.println(l.getDescription().toString());
        System.out.println(l.getPublisher().toString());
        System.out.println(l.getLanguage().toString());
        System.out.println(l.getDistributor().toString());
        System.out.println(l.getYear().toString());
        System.out.println(l.getPrice().toString());
        System.out.println(l.getImage().toString());
        dao.save(l);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Books> BookView()
    {
        return(List<Books>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Books> SearchBook(@RequestBody Books l){
        String title=l.getTitle();
        System.out.println(title);
        return (List<Books>) dao.SearchBook(l.getTitle());

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> delete(@RequestBody Books l){
        String id=String.valueOf(l.getId());
        System.out.println(id);
        dao.deleteBook(l.getId());
        HashMap <String,String> map =new HashMap<>();
        map.put("status","success");
        return map;

    }
 @Autowired
    private RegistrationDao dao1;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userreg",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegistration(@RequestBody Registration u){

        System.out.println(u.getName().toString());
        System.out.println(u.getAdhaar().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPincode().toString());
        System.out.println(u.getDob().toString());
        System.out.println(u.getPhonenumber().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getUsername().toString());
        dao1.save(u);
        HashMap <String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public List<Registration> UserLogin(@RequestBody Registration u){

        return (List<Registration>) dao1.userLogin(u.getUsername(), u.getPassword());
    }

}
