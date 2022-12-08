package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationDao extends CrudRepository <Registration,Integer> {

@Query(value = "SELECT `id`, `address`, `adhaar`, `confirmpassword`, `dob`, `email`, `name`, `password`, `phonenumber`, `pincode`, `username` FROM `registration` WHERE `username` =:username AND `password` =:password",nativeQuery = true)
List<Registration> userLogin(@Param("username") String username, @Param("password") String password);
}
