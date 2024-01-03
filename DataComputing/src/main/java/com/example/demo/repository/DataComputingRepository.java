package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DataComputingModel;

@Repository
public interface DataComputingRepository extends JpaRepository<DataComputingModel, Long> {
	
	@Query(value = "Select * from test_velocis order by id desc",nativeQuery = true)
	List<DataComputingModel> getDetails();

}
