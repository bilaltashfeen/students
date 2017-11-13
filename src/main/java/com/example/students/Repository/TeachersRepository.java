package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Teachers;
import com.example.students.Model.Teachers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository  extends CrudRepository<Teachers, Long> {


}