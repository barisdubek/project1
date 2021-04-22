package com.kocfinans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kocfinans.backend.model.CityScore;

@Repository
public interface CityScoreRepository extends JpaRepository<CityScore, Long>{
	
	@Query(value = "select c.city_score from city_score c where c.city_code = ?1", nativeQuery = true)
	Long findByCityCode(Long cityCode);

}
