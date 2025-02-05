package com.souza.charles.mongoDBSpringBoot.resources;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 05, 2025
 */

import com.souza.charles.mongoDBSpringBoot.dto.UserRequestDTO;
import com.souza.charles.mongoDBSpringBoot.dto.UserResponseDTO;
import com.souza.charles.mongoDBSpringBoot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {

    @Autowired
    private UserServices userServices;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<UserResponseDTO> insert (@RequestBody UserRequestDTO data){
        UserResponseDTO create = userServices.insert(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> list = userServices.findAll();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){
        UserResponseDTO result = userServices.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}