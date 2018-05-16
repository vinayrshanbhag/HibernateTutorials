package com.vinay.learning;

import com.vinay.learning.com.vinay.learning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
             session.beginTransaction();

             int studentId = 3002;

             Student student = session.get(Student.class, studentId);

             session.delete(student);
            session.getTransaction().commit();




            //new code
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("deleting using the query...");
            session.createQuery("delete from Student where id = 3006")
                    .executeUpdate();

            session.getTransaction().commit();


        }
        catch (Exception ex){

        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
