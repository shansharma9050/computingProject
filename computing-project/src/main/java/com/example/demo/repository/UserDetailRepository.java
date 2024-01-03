package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginTable;

@Repository
public interface UserDetailRepository extends JpaRepository<LoginTable, String> {

	@Query(value="SELECT * FROM LoginTable",nativeQuery = true)
	LoginTable getDetailOfUser(); 
	
	public LoginTable findByUsername(String username);
}
