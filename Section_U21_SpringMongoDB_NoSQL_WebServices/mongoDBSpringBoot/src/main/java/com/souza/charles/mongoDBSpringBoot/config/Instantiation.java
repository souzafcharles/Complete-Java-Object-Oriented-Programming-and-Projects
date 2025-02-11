package com.souza.charles.mongoDBSpringBoot.config;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.Post;
import com.souza.charles.mongoDBSpringBoot.domain.User;
import com.souza.charles.mongoDBSpringBoot.dto.AuthorResponseDTO;
import com.souza.charles.mongoDBSpringBoot.dto.CommentResponseDTO;
import com.souza.charles.mongoDBSpringBoot.repositories.PostRepository;
import com.souza.charles.mongoDBSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com");
        User user03 = new User(null, "Gonçalo Munhoz", "goncalo@email.com");
        User user04 = new User(null, "Vitalina Simplicio", "vitalina@email.com");
        User user05 = new User(null, "Ludovico Crispim", "ludovico@email.com");
        User user06 = new User(null, "Filisbina Junqueira", "filisbina@email.com");

        userRepository.saveAll(Arrays.asList(user01, user02, user03, user04, user05, user06));

        Post post01 = new Post(null, Instant.parse("2025-02-10T00:00:00Z"), "Trip departure", "I'm going to travel to São Paulo. Cheers!", new AuthorResponseDTO(user02));
        Post post02 = new Post(null, Instant.parse("2025-02-12T00:00:00Z"), "Good morning", "I woke up happy today!", new AuthorResponseDTO(user02));

        CommentResponseDTO comment01 = new CommentResponseDTO("Have a nice trip, dude!", Instant.parse("2025-02-10T00:00:00Z"), new AuthorResponseDTO(user01));
        CommentResponseDTO comment02 = new CommentResponseDTO("Enjoy!", Instant.parse("2025-02-11T00:00:00Z"), new AuthorResponseDTO(user04));
        CommentResponseDTO comment03 = new CommentResponseDTO("Have a great day!", Instant.parse("2025-02-12T00:00:00Z"), new AuthorResponseDTO(user01));
        post01.getComments().addAll(Arrays.asList(comment01, comment02));
        post02.getComments().add(comment03);

        postRepository.saveAll(Arrays.asList(post01, post02));

        user02.getPosts().addAll(Arrays.asList(post01, post02));

    }
}