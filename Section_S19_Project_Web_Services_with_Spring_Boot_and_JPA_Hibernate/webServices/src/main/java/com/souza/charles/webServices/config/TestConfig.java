package com.souza.charles.webServices.config;

import com.souza.charles.webServices.entities.User;
import com.souza.charles.webServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com", "+5599999999999", "******");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com", "+5511111111111", "******");
        User user03 = new User(null, "Ludovico Crispim", "ludovico@email.com", "+5522222222222", "******");

        userRepository.saveAll(Arrays.asList(user01, user02, user03));
    }
}