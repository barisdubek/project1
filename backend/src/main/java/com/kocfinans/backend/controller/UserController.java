package com.kocfinans.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kocfinans.backend.exception.ResourceNotFoundException;
import com.kocfinans.backend.model.User;
import com.kocfinans.backend.repository.CityScoreRepository;
import com.kocfinans.backend.repository.MontlyIncomeListRepository;
import com.kocfinans.backend.repository.ScoreSegmentRepository;
import com.kocfinans.backend.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MontlyIncomeListRepository montlyIncomeListRepository;
	
	@Autowired
	private CityScoreRepository cityScoreRepository;
	
	@Autowired
	private ScoreSegmentRepository scoreSegmentRepository;
	
	
	// getAll users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// create user
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		String IdNo = user.getId_number();
		User existedUser = userRepository.findUsersByIdNo(IdNo);

        if (!Objects.isNull(existedUser) ){
            userRepository.delete(existedUser);
        }
        
        long scoreSegment = Long.parseLong(scoreSegmentRepository.findByIdNo(user.getId_number())) ;
        long incomeRate = montlyIncomeListRepository.findByIncomeId(user.getMontly_income_id());
        long cityScore = cityScoreRepository.findByCityCode(user.getCity_code());
        
        
        long totalScore = (scoreSegment * incomeRate) + cityScore;
        user.setTotal_score(totalScore);
		
		return userRepository.save(user);
	}
	
	//get user byId
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update user byId
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setId_number(userDetails.getId_number());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPhone(userDetails.getPhone());
		user.setMontly_income_id(userDetails.getMontly_income_id());
		user.setCity_code(userDetails.getCity_code());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	// remove user byId
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	

}
