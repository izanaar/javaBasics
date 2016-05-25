package com.hbnt;

import com.hbnt.mdl.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/home/traum/Documents/Dropbox/dbCredentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Configuration configuration = new Configuration();
        configuration.setProperty("connection.password", properties.getProperty("db.password"));

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .configure(new File("/home/traum/Documents/Dropbox/hibernate.cfg.xml"))
                .build();

        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

       /* Employee employee = new Employee(0, "Gibolt", "Tuscan", 44242);

        saveEmployee(employee);*/

        System.out.println(getEmployee(1));
        sessionFactory.close();
    }

    private static Employee getEmployee(int id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee employee = null;
        try{
            tx = session.beginTransaction();
            employee =  session.get(Employee.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employee;
    }

    private static void saveEmployee(Employee employee){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            session.saveOrUpdate(employee);
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
