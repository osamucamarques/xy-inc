package br.com.zup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.model.InterestPoint;

@Repository
public interface InterestPointRepository extends CrudRepository<InterestPoint, Long> {

}
