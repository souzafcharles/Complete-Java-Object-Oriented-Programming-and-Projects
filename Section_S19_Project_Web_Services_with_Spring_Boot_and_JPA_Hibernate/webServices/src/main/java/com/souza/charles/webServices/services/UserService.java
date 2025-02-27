package com.souza.charles.webServices.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: January 29, 2025
 */

import com.souza.charles.webServices.entities.User;
import com.souza.charles.webServices.repositories.UserRepository;
import com.souza.charles.webServices.services.exceptions.DatabaseException;
import com.souza.charles.webServices.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> entity = userRepository.findById(id);
        return entity.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public User update(Long id, User data) {
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, data);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional
    private void updateData(User entity, User data) {
        entity.setName(data.getName());
        entity.setEmail(data.getEmail());
        entity.setPhone(data.getPhone());
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}