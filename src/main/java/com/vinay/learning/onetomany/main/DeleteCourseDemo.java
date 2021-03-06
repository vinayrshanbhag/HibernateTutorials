package com.vinay.learning.onetomany.main;

import com.vinay.learning.onetomany.entities.Course;
import com.vinay.learning.onetomany.entities.Instructor;
import com.vinay.learning.onetomany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);
            session.delete(course);


            session.getTransaction().commit();

        }
        catch (Exception ex){
           ex.printStackTrace();
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
