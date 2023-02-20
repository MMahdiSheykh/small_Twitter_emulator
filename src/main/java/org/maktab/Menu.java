package org.maktab;

import org.maktab.entities.User;
import org.maktab.services.ArticleService;
import org.maktab.services.UserService;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    ArticleService articleService = new ArticleService();
    public void welcomeMenu() {

        // printing detail of current panel
        System.out.println("Hi\nWelcome to your panel\n");//todo print name of current user
        System.out.println("1.Login\n2.Signup\n3.See articles\n4.Exit\n");

        // switch case of current panel
        int chooser = scanner.nextInt();
        switch (chooser) {
            case 1:
                // todo login method
                break;
            case 2:
                userService.createUser();
                break;
            case 3:
                // todo see articles
                break;
            case 4:
                break;
        }

    }
}
