package org.maktab.utils;

import org.maktab.entities.User;
import org.maktab.services.UserService;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Login {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();

    public User userLogin() {
        AtomicReference<User> user = new AtomicReference<>(new User());

        System.out.print("Please enter your username : \n--> ");
        String username = scanner.next();
        System.out.print("Please enter your password : \n--> ");
        String password = scanner.next();

        List<User> userList = userService.findAll();
        userList.forEach(x -> {
            if (Objects.equals(x.getUsername(), username) && Objects.equals(x.getPassword(), password)) {
                user.set(x);
            }
        });
        User user1 = user.getOpaque();

        return user1;
    }
}
