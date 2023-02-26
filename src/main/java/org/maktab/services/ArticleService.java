package org.maktab.services;

import org.maktab.entities.Article;
import org.maktab.entities.User;
import org.maktab.repositories.ArticleRepository;
import org.maktab.utils.ArticleUtils;

import java.util.List;
import java.util.Scanner;

public class ArticleService {
    Scanner scanner = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    public void createArticle(User user){
        Article article = new Article();
        ArticleUtils articleUtils = new ArticleUtils();

        System.out.print("\nPlease enter your article title : ");
        article.setTitle(scanner.next());
        System.out.print("Please enter your article brief : ");
        article.setBrief(scanner.next());
        System.out.print("Please enter your article content : ");
        article.setContent(scanner.next());
        article.setCreatedDate(articleUtils.getCurrentTime());
        article.setPublished(false);
        article.setUser(user);

        articleRepository.createArticle(article);
    }

    public List<Article> findAllArticles(){
        return articleRepository.findAllArticles();
    }

    public Article findByTitle(String title){
        return articleRepository.findByTitle(title);
    }

    public void updateArticle(Article editedArticle){
        articleRepository.editArticle(editedArticle);
    }
}
