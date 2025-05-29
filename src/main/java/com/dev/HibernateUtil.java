package com.dev;

import com.dev.model.Department;
import com.dev.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }


    }
}
