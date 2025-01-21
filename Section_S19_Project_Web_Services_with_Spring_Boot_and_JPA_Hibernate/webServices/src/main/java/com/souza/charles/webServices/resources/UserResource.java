package com.souza.charles.webServices.resources;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: January 21, 2025
 */
import com.souza.charles.webServices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Balthazar de Bigode", "balthazar@rmail.com", "+5516999999999", "******");
        return ResponseEntity.ok().body(user);
    }
}
