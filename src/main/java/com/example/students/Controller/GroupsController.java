package com.example.students.Controller;

//import com.example.student_mgmt_sys.Model.Groups;
//import com.example.student_mgmt_sys.Repository.GroupsRepository;
import com.example.students.Model.Groups;
import com.example.students.Repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GroupsController {

    @Autowired
    GroupsRepository groupsRepositiory;


    @GetMapping("/group")
    public String getgrouphome() {
        return "this is group";
    }

    // Create a new Group
    @PostMapping("/group")
    public Groups creategroups(@RequestBody Groups groups) {
        return groupsRepositiory.save(groups);
    }
    // Get a Single Groupid
    @GetMapping("/group/{id}")
    public ResponseEntity<Groups> getGroupsById(@PathVariable(value = "id") Long groupid) {
        Groups groups = groupsRepositiory.findOne(groupid);
        if(groups == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(groups);
    }
    // Update a Groups

    @PutMapping("/group/{id}")

    public ResponseEntity<Groups> updateGroup(@PathVariable(value = "id") Long groupid,
                                                  @Valid @RequestBody Groups StudentsDetails) {
        Groups groups = groupsRepositiory.findOne(groupid);
        if(groups == null) {
            return ResponseEntity.notFound().build();
        }
        groups.setId(StudentsDetails.getId());//Studentname());

        Groups updatedGroup = groupsRepositiory.save(groups);
        return ResponseEntity.ok(updatedGroup);
    }// Delete a group
    @DeleteMapping("/group/{id}")
    public ResponseEntity<Groups> deleteGroup(@PathVariable(value = "id") Long groupId) {
        Groups groups = groupsRepositiory.findOne(groupId);
        if(groups == null) {
            return ResponseEntity.notFound().build();
        }

        groupsRepositiory.delete(groups);
        return ResponseEntity.ok().build();
    }


}