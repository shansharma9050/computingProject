package com.example.demo.restApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataComputingModel;
import com.example.demo.repository.DataComputingRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/yourHomes")
public class DataComputingRestController {

	
	 @Autowired private DataComputingModel dataComputingModel;
	 
	@Autowired
	private DataComputingRepository dataComputingRepository;
	@RequestMapping(value="/get-data-computing-details",method = RequestMethod.GET)
	public List<DataComputingModel> getData()
	{
		List<DataComputingModel> dataComputingModelList=dataComputingRepository.getDetails();
		return dataComputingModelList;
	}
	
	@RequestMapping(value="/save-data-computing-details",method = RequestMethod.GET)
	public DataComputingModel saveData(@RequestBody DataComputingModel dataComputingModel)
	{
		return dataComputingRepository.save(dataComputingModel);
	}
}
