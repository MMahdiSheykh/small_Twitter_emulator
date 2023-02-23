package org.maktab.utils;

import org.maktab.entities.Article;
import org.maktab.entities.User;
import org.maktab.services.ArticleService;
import java.util.List;

public class ArticleUtils {
    ArticleService articleService = new ArticleService();

    public void editArticle(User user) {
        List<Article> articleList = articleService.findByUser();

        if (articleList != null) {
            articleList.forEach(x -> {
                if (x.getUser().getId() == user.getId()) {
                    System.out.println("\nTitle : " + x.getTitle() + "\nBrief : " + x.getBrief());
                } else {
                    System.out.println("There is no data to show!");
                }
            });
        }

    }
}
