package com.kocfinans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kocfinans.backend.model.MontlyIncomeList;


@Repository
public interface MontlyIncomeListRepository extends JpaRepository<MontlyIncomeList, Long>{

	@Query(value = "select m.income_rate from montly_income_list m where m.id = ?1", nativeQuery = true)
	Long findByIncomeId(Long monltyIncomeId);

}