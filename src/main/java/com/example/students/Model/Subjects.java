package com.example.students.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "subjects")
// @EntityListeners(AuditingEntityListener.class)
public class Subjects implements Serializable {

    private Long id;


    //    private Set<Students> students;
    private Set<Subject_Teachers> subject_teachers;
    private Set<Marks> marks;

    public Subjects() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subjects_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "subjects")
    public Set<Subject_Teachers> getSubject_teachers() {return subject_teachers;}

    public void setSubject_teachers(Set<Subject_Teachers> subject_teachers) {this.subject_teachers = subject_teachers;}

    @OneToMany(mappedBy = "subjects")
    public Set<Marks> getMarks() {
        return marks;
    }

    public void setMarks(Set<Marks> marks) {
        this.marks = marks;
    }
}