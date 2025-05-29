package com.dev;

import com.dev.model.Department;
import com.dev.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Department dcs = new Department();
            dcs.setName("DCS");

            Department IT = new Department();
            IT.setName("java");

            Department devOps = new Department();
            devOps.setName("DevOps");


            Employee employee = new Employee();
            employee.setName("anay");
            employee.setDepartment(dcs);

            Employee employee1 = new Employee();
            employee1.setName("dev");
            employee1.setDepartment(IT);

            Employee employee2 = new Employee();
            employee2.setName("tirth");
            employee2.setDepartment(IT);


            Employee employee3 = new Employee();
            employee3.setName("jaadu");
            employee3.setDepartment(devOps);

            session.persist(dcs);
            session.persist(employee);
            session.persist(IT);
            session.persist(employee1);
            session.persist(employee2);
            session.persist(devOps);
            session.persist(employee3);

            transaction.commit();

        }catch (Exception e){
            if (transaction != null) transaction.rollback();
        }finally {
            session.close();
        }
    }
}
