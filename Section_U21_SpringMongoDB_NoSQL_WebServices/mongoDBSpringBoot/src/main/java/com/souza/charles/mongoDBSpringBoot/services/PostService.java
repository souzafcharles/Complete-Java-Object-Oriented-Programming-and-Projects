package com.souza.charles.mongoDBSpringBoot.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 12, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.Post;
import com.souza.charles.mongoDBSpringBoot.dto.PostResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.PostRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.DateRangeInvalidException;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.ResourceNotFoundException;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.SearchResultNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PostService implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDTO findById(String id) {
        Post entity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PostResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> findByTitle(String text) {
        List<PostResponseDTO> list = postRepository.searchTitle(text);
        if (list.isEmpty()) {
            throw new SearchResultNotFoundException(text);
        }
        return list;
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> fullSearch(String text, Instant minDate, Instant maxDate) {
        if (minDate == null || maxDate == null) {
            throw new DateRangeInvalidException();
        }
        if (minDate.isAfter(maxDate)) {
            throw new DateRangeInvalidException();
        }
        if (minDate.isAfter(Instant.now())) {
            throw new DateRangeInvalidException();
        }
        maxDate = maxDate.plusSeconds(24 * 60 * 60);
        List<PostResponseDTO> list = postRepository.fullSearch(text, minDate, maxDate);
        if (list.isEmpty()) {
            throw new SearchResultNotFoundException(text);
        }
        return list;
    }
}