package com.example.students.Controller;

//import com.example.student_mgmt_sys.Model.Marks;
//import com.example.student_mgmt_sys.Repository.MarksRepository;
import com.example.students.Model.Marks;
import com.example.students.Repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MarksController {

    @Autowired
    MarksRepository marksRepositiory;


    @GetMapping("/mark")
    public String gethome() {
        return "this is marks";
    }

    // Get All Notes
//    @GetMapping("/emp")
//    public List<Students> getAllStudents() {
//        return emprepo.findAll();
//    }
    // Create a new Marks
    @PostMapping("/marks")
    public Marks createMarks(@RequestBody Marks marks) {
        return marksRepositiory.save(marks);
    }

    // Get a Single Marks
    @GetMapping("/marks/{id}")
    public ResponseEntity<Marks> getNoteById(@PathVariable(value = "id") Long marksid) {
        Marks marks = marksRepositiory.findOne(marksid);
        if (marks == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(marks);
    }
    // Update a Marks

    @PutMapping("/marks/{id}")
    public ResponseEntity<Marks> updateMarks(@PathVariable(value = "id") Long marksid,
                                            @Valid @RequestBody Marks Marksdetail) {
        Marks marks = marksRepositiory.findOne(marksid);
        if (marks == null) {
            return ResponseEntity.notFound().build();
        }
        marks.setId(Marksdetail.getId());

        Marks updatedStudent = marksRepositiory.save(marks);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete a Marks
    @DeleteMapping("/marks/{id}")
    public ResponseEntity<Marks> deleteMarks(@PathVariable(value = "id") Long StudentId) {
        Marks students = marksRepositiory.findOne(StudentId);
        if (students == null) {
            return ResponseEntity.notFound().build();
        }

        marksRepositiory.delete(students);
        return ResponseEntity.ok().build();
    }
}
