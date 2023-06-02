package lv.finals.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

}
