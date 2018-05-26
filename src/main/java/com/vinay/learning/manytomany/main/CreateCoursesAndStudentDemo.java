package com.vinay.learning.manytomany.main;

import com.vinay.learning.manytomany.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{



            session.beginTransaction();

            Course tempCourse = new Course("AWS- getting started");
            session.save(tempCourse);


            Student student1 = new Student("vinay","shanbhag", "vinay.shanbhag@fmr.com");
            Student student2= new Student("Shruthi", "Joshi", "shruthi.joshi@oracle.com");

             tempCourse.addStudent(student1);
             tempCourse.addStudent(student2);

            System.out.println("Saving  students");

             session.save(student1);
             session.save(student2);

            System.out.println("Saved Students" + tempCourse.getStudents());
            session.getTransaction().commit();

            System.out.println("Done");

        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println("There was a error while saving" +ex.getStackTrace());
        }
        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
