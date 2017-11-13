package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Subject_Teachers;
import com.example.students.Model.Subject_Teachers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Subject_TeacherRepository  extends CrudRepository<Subject_Teachers, Long> {


}