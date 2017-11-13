package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Students;
import com.example.students.Model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Students, Long> {


}