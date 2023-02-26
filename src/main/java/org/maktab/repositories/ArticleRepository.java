package org.maktab.repositories;

import org.hibernate.Session;
import org.maktab.dbConnection.DbConnection;
import org.maktab.entities.Article;
import java.util.List;

public class ArticleRepository {


    public void createArticle(Article article) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Article> findAllArticles() {
        Session session = null;
        List<Article> articleList = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.getTransaction();
            articleList = session.createQuery("FROM Article").list();
            return articleList;
        } catch (Exception sqlException) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return articleList;
    }

    public Article findByTitle(String title) {
        Session session = null;
        Article article = null;
//        try {
        session = DbConnection.buildSessionFactory().openSession();
        System.out.println("1");
        session.getTransaction();
        System.out.println("2");
        article = (Article) session.createSQLQuery("select * from articles where title = '" + title + "';").uniqueResult();
        System.out.println("3");
        return article;
//        } catch (Exception sqlException) {
//            System.out.println("\n..........Transaction is being rolled back..........\n");
//            session.getTransaction().rollback();
//        } finally {
//            if (session != null){
//                session.close();
//            }
//        }
//        return article;
    }

    public void editArticle(Article editedArticle) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.update(editedArticle);
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
