package com.prueba.crud.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prueba.crud.models.UserDTO;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String>{

}
