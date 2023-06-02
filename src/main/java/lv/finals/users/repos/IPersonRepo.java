package lv.finals.users.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.users.Person;

public interface IPersonRepo extends CrudRepository<Person, Long>{

}
