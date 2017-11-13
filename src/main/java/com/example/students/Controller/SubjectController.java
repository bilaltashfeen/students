package com.example.students.Controller;

//import com.example.student_mgmt_sys.Model.Subjects;
//import com.example.student_mgmt_sys.Repository.SubjectRepository;
import com.example.students.Model.Subjects;
import com.example.students.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    SubjectRepository studentRepositiory;


    @GetMapping("/subject")
    public String getsubject() {
        return "this is subject";
    }

    // Get All Notes
//    @GetMapping("/emp")
//    public List<Students> getAllStudents() {
//        return emprepo.findAll();
//    }
    // Create a new subject
    @PostMapping("/subject")
    public Subjects createSubject(@RequestBody Subjects subjects) {
        return studentRepositiory.save(subjects);
    }
    // Get a Single Subject
    @GetMapping("/subject/{id}")
    public ResponseEntity<Subjects> getSubjectById(@PathVariable(value = "id") Long subjectid) {
        Subjects subjects = studentRepositiory.findOne(subjectid);
        if(subjects == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(subjects);
    }
    // Update a Subject

    @PutMapping("/subject/{id}")
    public ResponseEntity<Subjects> updateSubject(@PathVariable(value = "id") Long subjectsid,
                                                       @Valid @RequestBody Subjects subjectdetail) {
        Subjects subjects = studentRepositiory.findOne(subjectsid);
        if(subjects == null) {
            return ResponseEntity.notFound().build();
        }
        subjects.setId(subjectdetail.getId());
        Subjects updatedStudent = studentRepositiory.save(subjects);
        return ResponseEntity.ok(updatedStudent);
    }
    // Delete a Subject
    @DeleteMapping("/subject/{id}")
    public ResponseEntity<Subjects> deleteSubject(@PathVariable(value = "id") Long subjectsid) {
        Subjects subjects = studentRepositiory.findOne(subjectsid);
        if(subjects == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepositiory.delete(subjects);
        return ResponseEntity.ok().build();
    }


}