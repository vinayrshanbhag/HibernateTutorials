package com.vinay.learning.one2one.entities.main;

import com.vinay.learning.one2one.entities.Instructor;
import com.vinay.learning.one2one.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

        //   int id = 2 ;

            int id =2999;

            InstructorDetail instructorDetail=   session.get(InstructorDetail.class, id);
            Instructor instructor = instructorDetail.getInstructor();

            System.err.println("The associated instructor is" + instructor);



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
