package com.souza.charles.mongoDBSpringBoot.resources;

import com.souza.charles.mongoDBSpringBoot.dto.PostResponseDTO;
import com.souza.charles.mongoDBSpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value="/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable String id){
        PostResponseDTO dto = postService.findByiId(id);
        return ResponseEntity.ok().body(dto);
    }
}
