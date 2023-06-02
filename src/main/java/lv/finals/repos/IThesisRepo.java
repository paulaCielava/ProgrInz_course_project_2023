package lv.finals.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.Thesis;

public interface IThesisRepo extends CrudRepository<Thesis, Long>{

}
