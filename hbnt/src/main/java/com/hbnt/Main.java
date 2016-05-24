package com.hbnt;

import com.hbnt.mdl.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Employee employee = new Employee(0, "Gibolt", "Tuscan", 44242);

        saveEmployee(employee);

        System.out.println(getEmployee(employee.getId()));
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
