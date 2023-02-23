package org.maktab.services;

import org.maktab.entities.Article;
import org.maktab.entities.User;
import org.maktab.repositories.ArticleRepository;

import java.util.List;
import java.util.Scanner;

public class ArticleService {
    Scanner scanner = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    public Article createArticle(User user){
        Article article = new Article();

        System.out.print("Please enter your article title : ");
        article.setTitle(scanner.next());
        System.out.println("Please enter your article brief : ");
        article.setBrief(scanner.next());
        System.out.println("Please enter your article content : ");
        article.setContent(scanner.next());
        System.out.println("Please enter article currently date : ");
        article.setCreatedDate(scanner.next());
        article.setPublished(false);
        article.setUser(user);

        articleRepository.createArticle(article);
        return article;
    }

    public List<Article> findByUser(){
        return articleRepository.findByUser();
    }
}
