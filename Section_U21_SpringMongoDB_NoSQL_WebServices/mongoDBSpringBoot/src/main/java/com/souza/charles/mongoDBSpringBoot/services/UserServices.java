package com.souza.charles.mongoDBSpringBoot.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 05, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;
import com.souza.charles.mongoDBSpringBoot.dto.UserResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.UserRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

@Service
public class UserServices implements Serializable {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(String id){
        User result = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        return new UserResponseDTO(result);
    }
}