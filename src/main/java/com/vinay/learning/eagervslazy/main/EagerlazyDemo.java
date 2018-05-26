package com.vinay.learning.eagervslazy.main;

import com.vinay.learning.eagervslazy.entities.Course;
import com.vinay.learning.eagervslazy.entities.Instructor;
import com.vinay.learning.eagervslazy.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerlazyDemo {

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

          /*  Instructor instructor = session.get(Instructor.class,id);

            System.out.println("Instructor"+ instructor);*/

            //option 1 is to call the the courses getter before the session is closed.


//            System.out.println("Courses"+ instructor.getCourses());

            //oprtion2 is to HQL join fetch

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                                           + "JOIN fetch i.courses "
                                                           + "where i.id = :theInstructorId", Instructor.class);

            query.setParameter("theInstructorId",id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor"+ instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Courses"+ instructor.getCourses());


        }
        catch (Exception ex){
            System.out.println("There was a error while saving" +ex);
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
