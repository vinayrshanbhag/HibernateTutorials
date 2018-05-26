package com.vinay.learning.onetomanyunidirectional.main;

import com.vinay.learning.onetomanyunidirectional.entities.Course;
import com.vinay.learning.onetomanyunidirectional.entities.Instructor;
import com.vinay.learning.onetomanyunidirectional.entities.InstructorDetail;
import com.vinay.learning.onetomanyunidirectional.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewDemo {

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

            Course tempCourse = new Course("Pacman- how to score one million points..");

            tempCourse.addReview(new Review("Greate couse.. loved it.."));
            tempCourse.addReview(new Review("Cool Course. loved it.."));
            tempCourse.addReview(new Review("Not a nice course..."));

            System.out.println("Saving the course...");


            session.save(tempCourse);



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
