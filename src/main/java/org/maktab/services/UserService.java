package org.maktab.services;

import org.maktab.entities.User;
import org.maktab.repositories.UserRepository;
import org.maktab.utils.LoginAndSignupUtils;
import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();
    LoginAndSignupUtils loginAndSignupUtils = new LoginAndSignupUtils();

    public User createUser(){

        User user = loginAndSignupUtils.userSignup();

        return userRepository.createUser(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
