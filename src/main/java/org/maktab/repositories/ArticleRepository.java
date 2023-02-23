package org.maktab.repositories;

import org.hibernate.Session;
import org.maktab.dbConnection.DbConnection;
import org.maktab.entities.Article;
import org.maktab.entities.User;

import java.util.List;

public class ArticleRepository {


    public Article createArticle(Article article) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        } catch (Exception sqlExeption) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return article;
    }

    public List<Article> findByUser() {
        Session session = null;
        List<Article> articleList = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.getTransaction();
            articleList = session.createQuery("FROM Article").list();
            return articleList;
        } catch (Exception sqlExeption) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return articleList;
    }
}
