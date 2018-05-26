package com.vinay.learning.manytomany.entities;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="Course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REFRESH},
                fetch=FetchType.LAZY)
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student>  students;


    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public void addStudent(Student student){
        if(students==null){
            students = new ArrayList<>();
        }


    students.add(student);

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Course(){

    }

    public Course(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        if(reviews==null){
            reviews= new ArrayList<>();
        }

        reviews.add(review);
    }
}
