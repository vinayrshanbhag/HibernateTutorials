package com.vinay.learning;

import com.vinay.learning.com.vinay.learning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            System.out.println("Creating a new Student");

            Student student = new Student("Vinay","Shanbhag","vinay.shanbhag@gmail.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

        }
        catch (Exception ex){

        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
