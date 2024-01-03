package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ComputingProjectModel;
import com.example.demo.model.LoginTable;

@Repository
public interface ComputeProjectRepository extends JpaRepository<ComputingProjectModel, Long> {

	@Query(value="SELECT * FROM COMPUTPRO ORDER BY ID DESC",nativeQuery = true)
	List<ComputingProjectModel> getAllDetails();
	
	@Query(value="SELECT * FROM COMPUTPRO WHERE ID=?",nativeQuery = true)
	List<ComputingProjectModel> detailsForEdit(Long id);
}
