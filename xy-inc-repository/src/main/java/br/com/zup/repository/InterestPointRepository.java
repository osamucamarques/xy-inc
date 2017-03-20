package br.com.zup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.model.InterestPoint;

@Repository
public interface InterestPointRepository
		extends CrudRepository<InterestPoint, Long>, JpaRepository<InterestPoint, Long> {

	@Query(value = "select point.* from interest_point point where point.x between (?1 - ?3) and (?1 + ?3) and point.y between (?2 - ?3) and (?2 + ?3)", nativeQuery = true)
	List<InterestPoint> findNearBy(int x, int y, int dmax);

}
