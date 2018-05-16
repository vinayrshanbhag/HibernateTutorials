package com.vinay.learning.onetomany.main;

import com.vinay.learning.onetomany.entities.Course;
import com.vinay.learning.onetomany.entities.Instructor;
import com.vinay.learning.onetomany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);

            Course course1 = new Course("Air Guitar- The ultimate Guide");
            Course course2 = new Course("PinBall -Master Class");

            instructor.add(course1);
            instructor.add(course2);



            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        }
        catch (Exception ex){
            System.out.println("There was a error while saving" +ex.getStackTrace());
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
