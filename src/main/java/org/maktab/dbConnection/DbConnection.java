package org.maktab.dbConnection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DbConnection {
    private static SessionFactory instance = null;

    private DbConnection() {
    }

    public static SessionFactory buildSessionFactory() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    Configuration configObj = new Configuration();

                    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml").build();

                    instance = configObj.buildSessionFactory(serviceRegistryObj);
                }
            }
        }
        return instance;
    }
}
