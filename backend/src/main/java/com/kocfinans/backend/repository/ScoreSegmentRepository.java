package com.kocfinans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kocfinans.backend.model.ScoreSegment;

@Repository
public interface ScoreSegmentRepository extends JpaRepository<ScoreSegment, Long>{
	
	@Query(value = "select s.score from score_segment s where s.id_No = ?1", nativeQuery = true)
	String findByIdNo(String idNo);

}
