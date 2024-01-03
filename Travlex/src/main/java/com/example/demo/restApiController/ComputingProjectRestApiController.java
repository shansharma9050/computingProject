package com.example.demo.restApiController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ComputingProjectModel;
import com.example.demo.repository.ComputeProjectRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/homes")
public class ComputingProjectRestApiController {

	@Autowired
	private ComputeProjectRepository computeProjectRepository;
	
	
	@PostMapping("/getDetails")
	public List<ComputingProjectModel> getDetails()
	{
		List<ComputingProjectModel> computingProjectModelList= computeProjectRepository.getAllDetails();
		
		return computingProjectModelList;
	}
	@GetMapping(name = "/computing-project-save-data")
	public ComputingProjectModel saveDetails(@RequestBody ComputingProjectModel computingProjectModel) throws ParseException{
		if(computingProjectModel.getDob()!=null)
		{
			String Date=computingProjectModel.getDob();
			java.util.Date dt=new SimpleDateFormat("yyyy-MM-dd").parse(Date);
			computingProjectModel.setDob1(dt);
			
		}
		
		 return computeProjectRepository.save(computingProjectModel);
	}
	@GetMapping("/get-data-for-edit")
	public List<ComputingProjectModel> editData(@RequestParam ComputingProjectModel computingProjectModel)
	{
	List<ComputingProjectModel> computingProjectModel12=computeProjectRepository.detailsForEdit(computingProjectModel.getId());
	return computingProjectModel12;
	}
}
