package org.maktab.utils;

import org.maktab.entities.Article;
import org.maktab.entities.User;
import org.maktab.services.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ArticleUtils {
    ArticleService articleService = new ArticleService();
    Scanner scanner = new Scanner(System.in);

    public void printUserArticles(User user) {
        List<Article> articleList = articleService.findAllArticles();

        if (articleList != null) {
            AtomicInteger atomicCounter = new AtomicInteger(0);

            articleList.forEach(x -> {
                if (x.getUser().getId() == user.getId()) {
                    System.out.println("\nTitle : " + x.getTitle() + "\nBrief : " + x.getBrief());
                    atomicCounter.getAndIncrement();
                }
            });
            int counter = atomicCounter.intValue();
            if (counter == 0) {
                System.out.println("\nYou dont have any article!");
            }
        }
    }

    public void printAllArticles() {
        List<Article> articleList = articleService.findAllArticles();

        articleList.forEach(x -> System.out.println("\nTitle : " + x.getTitle() + "\nBrief : " + x.getBrief()));
    }

    public void findArticleByTitle() {
        System.out.print("\nPlease enter the title of the article you want\n--> ");

        List<Article> articleList = articleService.findAllArticles();
        Article article = new Article();

        while (true) {
            String title = scanner.next();

            articleList.forEach(x -> {
                if (x.getTitle().equals(title)) {
                    article.setId(x.getId());
                    article.setTitle(x.getTitle());
                    article.setBrief(x.getBrief());
                    article.setContent(x.getContent());
                    article.setCreatedDate(x.getCreatedDate());
                    article.setUser(x.getUser());
                }
            });

            if (article.getTitle() != null) {
                System.out.println(article.toString());
                break;
            } else {
                System.out.print("\nThe entered title does not exist!\nPlease try again\n--> ");
            }
        }
    }

    public List<Article> findUserArticles(User user) {
        List<Article> articleList = articleService.findAllArticles();
        List<Article> userArticles = new ArrayList<>();

        articleList.forEach(x -> {
            if (x.getUser().getId() == user.getId()) {
                userArticles.add(x);
            }
        });
        return userArticles;
    }

    public Article findAnArticleFromUserArticles(User user) {
        System.out.print("\nPlease enter the title of the article you want to edit\n--> ");
        String title = scanner.next();

        List<Article> userArticles = findUserArticles(user);
        AtomicReference<Article> atomicArticle = new AtomicReference<>(new Article());

        userArticles.forEach(x -> {
            if (x.getTitle().equals(title)) {
                atomicArticle.set(x);
            }
        });

        Article article = atomicArticle.getOpaque();

        if (article.getUser() != null) {
            return article;
        } else {
            System.out.println("This title does not exist!");
        }
        return null;
    }

    public Article editAnArticle(Article article) {
        System.out.print("\nWhich part of the article do you want to edit\n" +
                "\n1.Title : " + article.getTitle() +
                "\n2.Brief : " + article.getBrief() +
                "\n3.Content : " + article.getContent() +
                "\n\n--> ");

        int chooser = scanner.nextInt();
        switch (chooser) {
            case 1:
                System.out.print("Please enter the new title : ");
                article.setTitle(scanner.next());
                break;
            case 2:
                System.out.print("Please enter the new brief : ");
                article.setBrief(scanner.next());
                break;
            case 3:
                System.out.print("Please enter the new content : ");
                article.setContent(scanner.next());
                break;
        }
        return article;
    }
}
