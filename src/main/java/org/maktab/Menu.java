package org.maktab;

import org.maktab.entities.User;
import org.maktab.services.UserService;
import org.maktab.utils.LoginAndSignupUtils;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    LoginAndSignupUtils loginAndSignupUtils = new LoginAndSignupUtils();
    User currentUser;

    public void welcomeMenu() {

        // printing detail of current panel
        System.out.println("\nWelcome to your app\n");
        System.out.println("1.Login\n2.Signup\n3.See articles\n4.Exit\n");

        // testing the entered number
        while (true) {

            System.out.print("--> ");
            int chooser = scanner.nextInt();

            if (chooser > 0 && chooser < 5) {
                // switch case of current panel
                switch (chooser) {
                    case 1:
                        currentUser = loginAndSignupUtils.userLogin();
                        loginMenu(currentUser);
                        break;
                    case 2:
                        currentUser = userService.createUser();
                        loginMenu(currentUser);
                        break;
                    case 3:
                        // todo see articles
                        break;
                    case 4:
                        break;
                }
                break;

            } else {
                System.out.println("\nplease enter a correct number...! ");
            }
        }
    }

    public void loginMenu(User user){
        System.out.println("test");
    }
}
