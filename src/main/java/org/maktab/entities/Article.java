package org.maktab.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
    long createdDate;
    boolean isPublished;
    @ManyToOne
    User user;

    @Override
    public String toString() {
        return "\n" +
                "Title : " + title + '\n' +
                "Brief : " + brief + '\n' +
                "Content : " + content + '\n' +
                "CreatedDate : " + new SimpleDateFormat("dd/MM/yyyy").format(new Timestamp(createdDate)) + '\n' +
                "Author : " + user.getUsername() +
                "\n";
    }
}
