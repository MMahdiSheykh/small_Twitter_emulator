package org.maktab.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String brief;
    String content;
    String createdDate;
    boolean isPublished;
    @ManyToOne
    User user;

    @Override
    public String toString() {
        return "\n" +
                "Title : " + title + '\n' +
                "Brief : " + brief + '\n' +
                "Content : " + content + '\n' +
                "CreatedDate : " + createdDate + '\n' +
                "Author : " + user.getUsername() +
                "\n";
    }
}
