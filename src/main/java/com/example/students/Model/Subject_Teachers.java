package com.example.students.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject_teacehrs")

public class Subject_Teachers implements Serializable {

    private int id;
     private Groups groups;
     private Teachers teachers;
        private Subjects subjects;
    public Subject_Teachers()
    {

    }

    public Subject_Teachers(int id) {this.id = id;	}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_teacherid")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "groupid")
    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "teachers_id")
    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
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