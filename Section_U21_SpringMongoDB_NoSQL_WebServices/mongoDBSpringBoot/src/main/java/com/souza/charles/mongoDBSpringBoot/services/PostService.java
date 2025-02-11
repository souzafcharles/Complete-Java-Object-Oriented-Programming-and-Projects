package com.souza.charles.mongoDBSpringBoot.services;

import com.souza.charles.mongoDBSpringBoot.domain.Post;
import com.souza.charles.mongoDBSpringBoot.dto.PostResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.PostRepository;
import com.souza.charles.mongoDBSpringBoot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class PostService implements Serializable {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDTO findByiId(String id) {
        Post entity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PostResponseDTO(entity);
    }
}
