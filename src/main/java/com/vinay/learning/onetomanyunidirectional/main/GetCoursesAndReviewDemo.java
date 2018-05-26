package com.vinay.learning.onetomanyunidirectional.main;

import com.vinay.learning.onetomanyunidirectional.entities.Course;
import com.vinay.learning.onetomanyunidirectional.entities.Instructor;
import com.vinay.learning.onetomanyunidirectional.entities.InstructorDetail;
import com.vinay.learning.onetomanyunidirectional.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCoursesAndReviewDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

          int id = 10;

          Course course = session.get(Course.class, id);

            System.out.println("Courses: " + course);

            List<Review> reviews = course.getReviews();

            System.out.println("Reviews: " + reviews);



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
