package com.example.students.Repository;

//import com.example.student_mgmt_sys.Model.Subjects;
import com.example.students.Model.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subjects, Long> {


}