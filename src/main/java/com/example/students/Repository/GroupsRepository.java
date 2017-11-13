package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Groups;
import com.example.students.Model.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository  extends CrudRepository<Groups, Long> {


}