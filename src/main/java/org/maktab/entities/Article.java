package org.maktab.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String brief;
    private String content;
    private String createdDate;
    private boolean isPublished;
    private int user_id;
}
