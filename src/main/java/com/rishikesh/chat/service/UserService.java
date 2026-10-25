package com.rishikesh.chat.service;

//Importing the user entity
import com.rishikesh.chat.entity.User;

//import Userepository
import com.rishikesh.chat.repository.UserRepository;

//marks this class as a service 
import org.springframework.stereotype.Service;

@Service // telling spring that this class is containing a business logic
public class UserService {

    private final UserRepository userRepository; // connecting service-> DB

    // creating UserService with this repo -> DB
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // takes a user ->sends to repo->repo sends to DB
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    // Overall Logic--> UserService -> UserRepository, PostgreSQL

}
