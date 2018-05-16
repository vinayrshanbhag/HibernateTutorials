package com.vinay.learning;

import com.vinay.learning.com.vinay.learning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
             session.beginTransaction();

             int studentId = 3002;

            System.out.println("Getting the Student with Id 30002");

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating the email id");

            student.setEmail("vaidehi.shanbhag@gmail.com");

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Updating email id");

            session.createQuery("update Student set email = 'abd.xyz@gmail.com'")
                    .executeUpdate();

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
