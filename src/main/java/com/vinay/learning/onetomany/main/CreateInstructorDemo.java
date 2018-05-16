package com.vinay.learning.onetomany.main;

import com.vinay.learning.onetomany.entities.Course;
import com.vinay.learning.onetomany.entities.Instructor;
import com.vinay.learning.onetomany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{


            Instructor instructor = new Instructor("Shruthi", "Joshi","Shruthi.Joshi@live.com");

            InstructorDetail instructorDetails = new InstructorDetail("youtube.com/shruthijoshi", "throwball");

            instructor.setInstructorDetail(instructorDetails);

            session.beginTransaction();


            session.save(instructor);

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
