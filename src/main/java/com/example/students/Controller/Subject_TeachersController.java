package com.example.students.Controller;

//import com.example.student_mgmt_sys.Model.Subject_Teachers;
//import com.example.student_mgmt_sys.Repository.Subject_TeacherRepository;
import com.example.students.Model.Subject_Teachers;
import com.example.students.Repository.Subject_TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Subject_TeachersController {

    @Autowired
    Subject_TeacherRepository studentRepositiory;


    @GetMapping("/std_thr")
    public String gethome() {
        return "this is student_teacher";
    }

    // Get All Notes
//    @GetMapping("/emp")
//    public List<Students> getAllStudents() {
//        return emprepo.findAll();
//    }
    // Create a new Student
    @PostMapping("/std_thr")
    public Subject_Teachers createNote(@RequestBody Subject_Teachers students) {
        return studentRepositiory.save(students);
    }
    // Get a Single Subject
    @GetMapping("/std_thr/{id}")
    public ResponseEntity<Subject_Teachers> getNoteById(@PathVariable(value = "id") Long studentid) {
        Subject_Teachers student = studentRepositiory.findOne(studentid);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student);
    }
    // Update a Subject

    @PutMapping("/std_thr/{id}")
    public ResponseEntity<Subject_Teachers> updateNote(@PathVariable(value = "id") Long studentsId,
                                               @Valid @RequestBody Subject_Teachers StudentsDetails) {
        Subject_Teachers students = studentRepositiory.findOne(studentsId);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        students.setId(StudentsDetails.getId());

        Subject_Teachers updatedStudent = studentRepositiory.save(students);
        return ResponseEntity.ok(updatedStudent);
    }
    // Delete a Stu
    @DeleteMapping("/std_thr/{id}")
    public ResponseEntity<Subject_Teachers> deleteStudent(@PathVariable(value = "id") Long StudentId) {
        Subject_Teachers students = studentRepositiory.findOne(StudentId);
        if(students == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepositiory.delete(students);
        return ResponseEntity.ok().build();
    }


}