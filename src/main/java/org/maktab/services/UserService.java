package org.maktab.services;

import org.maktab.entities.User;
import org.maktab.repositories.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User createUser(User user){
        userRepository.createUser(user);
        return user;
    }
}
