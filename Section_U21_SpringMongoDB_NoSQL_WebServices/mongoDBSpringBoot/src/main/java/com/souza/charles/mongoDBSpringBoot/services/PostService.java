package com.souza.charles.mongoDBSpringBoot.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.Post;
import com.souza.charles.mongoDBSpringBoot.dto.PostResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.PostRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Service
public class PostService implements Serializable {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDTO findById(String id) {
        Post entity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PostResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> fullSearch(String text, Instant minDate, Instant maxDate) {
        maxDate = maxDate.plusSeconds(24 * 60 * 60);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}