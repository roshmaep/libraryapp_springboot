package com.example.libraryapp_backend.dao;

import com.example.libraryapp_backend.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends CrudRepository <Books,Integer> {
    @Query(value = "SELECT `id`, `author`, `description`, `distributor`, `image`, `language`, `price`, `publisher`, `title`, `year` FROM `books` WHERE `title` =:title",nativeQuery = true)
    List<Books> SearchBook(@Param("title") String title);

    @Modifying
    @Transactional
     @Query(value = "DELETE FROM `books` WHERE `id`= :id",nativeQuery = true)
    void deleteBook(@Param("id")Integer id);
}
