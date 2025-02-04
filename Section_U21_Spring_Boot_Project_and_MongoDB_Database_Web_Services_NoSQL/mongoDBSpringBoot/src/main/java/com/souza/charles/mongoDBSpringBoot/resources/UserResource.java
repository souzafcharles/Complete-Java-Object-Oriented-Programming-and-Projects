package com.souza.charles.mongoDBSpringBoot.resources;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 04, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        User user01 = new User(1001L, "Balthazar de Bigode", "balthazar@email.com");
        User user02 = new User(1002L, "Ophelia Birrenta", "ophelia@email.com");
        list.addAll(Arrays.asList(user01, user02));
        return ResponseEntity.ok().body(list);
    }
}