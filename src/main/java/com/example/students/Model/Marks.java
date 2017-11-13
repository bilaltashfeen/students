package com.example.students.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marks")

public class Marks implements Serializable {

    private int id;

    //	@NotBlank
    private Students students;
    private Subjects subjects;

    public Marks()
    {

    }
    public Marks(int id) {this.id = id;	}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marks_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id")
    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "subjects_id")
    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
}