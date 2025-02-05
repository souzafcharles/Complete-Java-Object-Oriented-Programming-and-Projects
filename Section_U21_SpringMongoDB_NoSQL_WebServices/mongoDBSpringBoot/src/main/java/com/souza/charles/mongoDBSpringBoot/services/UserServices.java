package com.souza.charles.mongoDBSpringBoot.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 05, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;
import com.souza.charles.mongoDBSpringBoot.dto.UserRequestDTO;
import com.souza.charles.mongoDBSpringBoot.dto.UserResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.UserRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.DatabaseException;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

@Service
public class UserServices implements Serializable {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO insert(UserRequestDTO data) {
        User user = new User(data);
        User create = userRepository.insert(user);
        return new UserResponseDTO(create);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(String id) {
        User result = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserResponseDTO(result);
    }

    @Transactional
    public void delete(String id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}