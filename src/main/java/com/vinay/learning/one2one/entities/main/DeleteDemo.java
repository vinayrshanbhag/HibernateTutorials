package com.vinay.learning.one2one.entities.main;

import com.vinay.learning.one2one.entities.Instructor;
import com.vinay.learning.one2one.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);

            session.delete(instructor);




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
