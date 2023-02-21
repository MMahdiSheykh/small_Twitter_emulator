package org.maktab.repositories;

import org.hibernate.Session;
import org.maktab.dbConnection.DbConnection;
import org.maktab.entities.User;

import java.util.List;

public class UserRepository {

    public User createUser(User user) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception sqlExeption) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public List<User> findAll() {
        Session session = null;
        List<User> userList = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            userList = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();
        } catch (Exception sqlExeption) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userList;
    }

    public User updatePassword(User user, String password) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.getTransaction();
            user.setPassword(password);
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception sqlExeption) {
            System.out.println("\n..........Transaction is being rolled back..........\n");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }
}
