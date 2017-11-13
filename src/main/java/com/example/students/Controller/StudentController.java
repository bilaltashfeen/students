package com.example.students.Controller;


//import com.example.student_mgmt_sys.Model.Students;
//import com.example.student_mgmt_sys.Repository.StudentRepository;
import com.example.students.Model.Students;
import com.example.students.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepositiory;


    @GetMapping("/std")
    public String getstudent() {
        return "this is student";
    }

    // Get All Notes
//    @GetMapping("/emp")
//    public List<Students> getAllStudents() {
//        return emprepo.findAll();
//    }
    // Create a new Student
    @PostMapping("/student")
    public Students createStudents(@RequestBody Students students) {
        return studentRepositiory.save(students);
    }
    // Get a Single Student
    @GetMapping("/student/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable(value = "id") Long studentid) {
        Students student = studentRepositiory.findOne(studentid);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student);
    }
    // Update a Student

    @PutMapping("/student/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable(value = "id") Long studentsId,
                                               @Valid @RequestBody Students StudentsDetails) {
        Students students = studentRepositiory.findOne(studentsId);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        students.setName(StudentsDetails.getName());

        Students updatedStudent = studentRepositiory.save(students);
        return ResponseEntity.ok(updatedStudent);
    }
    // Delete a Student
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Students> deleteStudent(@PathVariable(value = "id") Long StudentId) {
        Students students = studentRepositiory.findOne(StudentId);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepositiory.delete(students);
        return ResponseEntity.ok().build();
    }


}