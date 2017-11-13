package com.example.students.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")

public class Students implements Serializable {

	private int id;

	//	@NotBlank
	private String title;
//	private Set<Marks> marks;
	private Groups groups;
	private Marks marks;
	private String name;

	public Students()
	{

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Students(int id, String title) {this.id = id; this.title = title;	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	@JoinColumn(name = "marks_id")
	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}
}