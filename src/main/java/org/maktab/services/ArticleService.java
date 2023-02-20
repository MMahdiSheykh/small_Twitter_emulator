package org.maktab.services;

import org.maktab.entities.Article;
import org.maktab.repositories.ArticleRepository;

public class ArticleService {
    ArticleRepository articleRepository = new ArticleRepository();
    public Article createArticle(Article article){
        articleRepository.createArticle(article);
        return article;
    }
}
