package org.maktab.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue
    int id;
    String title;
    String brief;
    String content;
    String createdDate;
    boolean isPublished;
    int user_id;
}
