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
                    configObj.configure("hibernate.cfg.xml");

                    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                            .applySettings(configObj.getProperties()).build();

                    instance = configObj.buildSessionFactory(serviceRegistryObj);
                }
            }
        }
        return instance;
    }
}
