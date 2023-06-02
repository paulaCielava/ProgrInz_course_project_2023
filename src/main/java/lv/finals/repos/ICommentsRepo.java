package lv.finals.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.Comments;

public interface ICommentsRepo extends CrudRepository<Comments, Long>{

}
