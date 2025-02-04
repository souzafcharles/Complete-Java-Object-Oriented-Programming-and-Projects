package com.souza.charles.mongoDBSpringBoot.repositories;

import com.souza.charles.mongoDBSpringBoot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
