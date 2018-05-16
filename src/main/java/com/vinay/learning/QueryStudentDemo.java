package com.vinay.learning;

import com.vinay.learning.com.vinay.learning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

            System.out.println("Querying the Student");

            List<Student> students = session.createQuery("from Student")
                                             .getResultList();

            students.stream()
                    .forEach(System.out::println);

            System.out.println("Getting specific Student");
            students = session.createQuery("from Student s where s.firstName='Vinay'")
                              .getResultList();


            students.stream()
                    .forEach(System.out::println);

            System.out.println("Having or condition");

            students = session.createQuery("from Student s where s.firstName='Vinay' OR s.firstName = 'Joshi'")
                            .getResultList();

            students.stream()
                    .forEach(System.out::println);

            System.out.println("Having Like condition");

            students = session.createQuery("from Student s where s.email LIKE '%joshi%'")
                              .getResultList();

            students.stream()
                    .forEach(System.out::println);

            session.getTransaction().commit();


            System.out.println("Done");

        }
        catch (Exception ex){
            System.out.println("There was an error" + ex.getStackTrace());
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
