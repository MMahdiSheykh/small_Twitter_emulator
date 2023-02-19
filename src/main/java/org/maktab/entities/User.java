package org.maktab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String nationalCode;
    private String birthday;
    private String password;
}
