package org.maktab;


import org.maktab.entities.User;
import org.maktab.repositories.UserRepository;
import org.maktab.utils.Login;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        User user = login.userLogin();
        System.out.println(user);


    }
}