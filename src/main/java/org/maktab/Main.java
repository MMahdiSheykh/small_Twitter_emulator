package org.maktab;

import org.maktab.entities.Article;
import org.maktab.entities.User;
import org.maktab.repositories.ArticleRepository;
import org.maktab.repositories.UserRepository;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("mahdi");
        user.setPassword("mahdi");
        user.setBirthday("20/07/1400");
        user.setNationalCode("220154870");

        UserRepository userRepository = new UserRepository();
        userRepository.createUser(user);

        Article article = new Article();
        article.setTitle("first");
        article.setContent("alu");
        article.setBrief("mammad");
        article.setPublished(true);
        article.setCreatedDate("date");
        article.setUser(user);

        ArticleRepository articleRepository = new ArticleRepository();
        articleRepository.createArticle(article);

    }
}