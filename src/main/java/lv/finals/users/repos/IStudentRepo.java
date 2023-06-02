package lv.finals.users.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.users.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{

}
