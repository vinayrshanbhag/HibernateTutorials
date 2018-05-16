package com.vinay.learning.one2one.entities.main;

import com.vinay.learning.com.vinay.learning.entity.Student;
import com.vinay.learning.one2one.entities.Instructor;
import com.vinay.learning.one2one.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{


            Instructor vinay = new Instructor("Shruthi", "Joshi","Shruthi.Joshi@live.com");

            InstructorDetail vinaysDetails = new InstructorDetail("youtube.com/vinayshanbhag", "cricket");

            vinay.setInstructorDetail(vinaysDetails);

            session.beginTransaction();


             session.save(vinay);

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
