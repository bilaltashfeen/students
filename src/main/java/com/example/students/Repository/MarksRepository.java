package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Marks;
import com.example.students.Model.Marks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository  extends CrudRepository<Marks, Long> {


}