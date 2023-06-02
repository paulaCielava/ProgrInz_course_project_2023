package lv.finals.users.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.users.User;

public interface IUserRepo extends CrudRepository<User, Long>{

}
