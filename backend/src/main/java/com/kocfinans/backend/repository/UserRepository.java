package com.kocfinans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kocfinans.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select * from users s where s.id_number = ?1", nativeQuery = true)
	User findUsersByIdNo(String IdNo);
}
