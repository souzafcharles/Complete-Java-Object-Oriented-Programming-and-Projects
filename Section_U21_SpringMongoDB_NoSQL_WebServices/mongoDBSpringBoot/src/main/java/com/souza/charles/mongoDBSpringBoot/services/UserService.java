package com.souza.charles.mongoDBSpringBoot.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 09, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;
import com.souza.charles.mongoDBSpringBoot.dto.UserRequestDTO;
import com.souza.charles.mongoDBSpringBoot.dto.UserResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.UserRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO insert(UserRequestDTO data) {
        if (data.name() == null || data.name().isEmpty() ||
                data.email() == null || data.email().isEmpty()) {
            throw new InvalidDataException();
        }
        if (userRepository.findByEmail(data.email()).isPresent()) {
            throw new DuplicateEmailException(data.email());
        }
        User entity = new User(data);
        User create = userRepository.insert(entity);
        return new UserResponseDTO(create);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        try {
            List<User> list = userRepository.findAll();
            return list.stream()
                    .map(UserResponseDTO::new)
                    .toList();
        } catch (InvalidDataAccessResourceUsageException e) {
            throw new EmptyTableException();
        }
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(String id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findByEmail(String email) {
        User entity = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email));
        return new UserResponseDTO(entity);
    }

    @Transactional
    public UserResponseDTO update(String id, UserRequestDTO data) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        if (data.email() != null) {
            userRepository.findByEmail(data.email())
                    .filter(existingUser -> !existingUser.getId().equals(id))
                    .ifPresent(user -> {
                        throw new DuplicateEmailException(data.email());
                    });
        }
        updateData(entity, data);
        User updatedUser = userRepository.save(entity);
        return new UserResponseDTO(updatedUser);
    }

    private void updateData(User entity, UserRequestDTO data) {
        if (data.name() == null || data.name().isEmpty() ||
                data.email() == null || data.email().isEmpty()) {
            throw new InvalidDataException();
        }
        entity.setName(data.name());
        entity.setEmail(data.email());
    }

    @Transactional
    public void delete(String id) {
        try {
            userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}