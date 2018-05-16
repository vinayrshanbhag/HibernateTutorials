package com.vinay.learning;

import com.vinay.learning.com.vinay.learning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            System.out.println("Creating a new Student");

            Student Deepa = new Student("Deepa","   Shanbhag","Deepa.shanbhag@fmr.com");

            session.beginTransaction();

            session.save(Deepa);

            session.getTransaction().commit();
            System.out.println("Saved Student. Generated id "+ Deepa.getId());

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, Deepa.getId());

            System.out.println("Get Complete +" + retrievedStudent);

            session.getTransaction().commit();
            System.out.println("Done");

        }
        catch (Exception ex){

        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
