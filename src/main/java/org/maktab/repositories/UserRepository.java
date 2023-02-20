package org.maktab.repositories;

import org.hibernate.Session;
import org.maktab.dbConnection.DbConnection;
import org.maktab.entities.User;

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
}
