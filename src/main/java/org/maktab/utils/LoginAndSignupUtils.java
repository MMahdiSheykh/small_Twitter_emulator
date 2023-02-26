package org.maktab.utils;

import org.maktab.entities.User;
import org.maktab.services.UserService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class LoginAndSignupUtils {
    Scanner scanner = new Scanner(System.in);

    public User userLogin() {

        UserService userService = new UserService();
        AtomicReference<User> atomicUser = new AtomicReference<>(new User());

        while (true) {
            System.out.print("\nPlease enter your username\n--> ");
            String username = scanner.next();
            System.out.print("Please enter your password\n--> ");
            String password = scanner.next();

            List<User> userList = userService.findAll();

            userList.forEach(x -> {
                if (x.getUsername().equals(username) && x.getPassword().equals(password)) {
                    atomicUser.set(x);
                }
            });

            User user = atomicUser.getOpaque();

            if (user.getUsername() == null) {
                System.out.println("\nyour username or password is incorrect...!\nTry again");
            } else {
                return user;
            }
        }
    }

    public User userSignup() {
        User user = new User();

        System.out.print("\nPlease enter your username\n--> ");
        user.setUsername(scanner.next());
        System.out.print("Please enter your national code\n--> ");
        String nationalCode = scanner.next();
        user.setNationalCode(nationalCode);
        System.out.print("Please enter your birthday\n--> ");
        user.setBirthday(scanner.next());

        String newPassword = changePassword();

        if (newPassword != null) {
            user.setPassword(newPassword);
        } else {
            user.setPassword(nationalCode);
        }
        return user;
    }

    public String changePassword() {
        String newPassword = null;

        System.out.println("\nYour national code has been registered as your login password\nDo you want change it?");
        System.out.print("\n1.Yse\n2.No\n\n--> ");

        int chooser;
        while (true) {
            chooser = scanner.nextInt();

            if (chooser == 1 || chooser == 2) {
                switch (chooser) {
                    case 1:
                        System.out.print("\nPlease enter your new password\n--> ");
                        newPassword = scanner.next();
                        break;
                    case 2:
                        break;
                }
                return newPassword;
            } else {
                System.out.print("\nplease enter a correct number...!\n-->");

            }
        }
    }
}
