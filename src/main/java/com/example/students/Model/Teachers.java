package com.example.students.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teachers")
// @EntityListeners(AuditingEntityListener.class)
public class Teachers implements Serializable {

    private Long id;


//    private Set<Students> students;
    private Set<Subject_Teachers> subject_teachers;


    public Teachers() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teachers_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "teachers")
    public Set<Subject_Teachers> getSubject_teachers() {return subject_teachers;}

    public void setSubject_teachers(Set<Subject_Teachers> subject_teachers) {this.subject_teachers = subject_teachers;}
}