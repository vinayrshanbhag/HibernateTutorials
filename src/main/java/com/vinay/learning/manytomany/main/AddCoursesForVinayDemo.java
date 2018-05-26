package com.vinay.learning.manytomany.main;

import com.vinay.learning.manytomany.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForVinayDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();


            Student student = session.get(Student.class, 1);

            System.out.println("Loaded the student"+ student);

            Course course1 = new Course("Spring boot - Getting started");

            Course course2 = new Course("Atari- Getting started with gaming");

            course1.addStudent(student);
            course2.addStudent(student);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done");

        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println("There was a error while saving" +ex.getStackTrace());
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
