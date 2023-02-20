package org.maktab.services;

import org.maktab.entities.User;
import org.maktab.repositories.UserRepository;

import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();

    public User createUser(){
        User user = new User();

        System.out.print("\nPlease enter your username : ");
        user.setUsername(scanner.next());
        System.out.print("Please enter your password : ");
        user.setPassword(scanner.next());
        System.out.print("Please enter your national code : ");
        user.setNationalCode(scanner.next());
        System.out.print("Please enter your birthday : ");
        user.setBirthday(scanner.next());

        userRepository.createUser(user);
        return user;
    }
}
