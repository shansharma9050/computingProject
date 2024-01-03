package com.example.demo.restApiController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.model.ComputingProjectModel;
import com.example.demo.repository.ComputeProjectRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/myHome")
public class ComputingProjectRestApiController {

	@Autowired
	private ComputeProjectRepository computeProjectRepository;
	
	
	@RequestMapping(value="/getDetails",method = {RequestMethod.GET})
	public ResponseEntity<ResponseDto> getDetails()
	{
		ResponseDto responseDto=new ResponseDto();
		List<ComputingProjectModel> computingProjectModelList= computeProjectRepository.getAllDetails();
		
		
		responseDto.setComputingProjectModelList(computingProjectModelList);
		
		return ResponseEntity.ok(responseDto); /*computingProjectModelList.stream().filter(a->a!=null).collect(Collectors.toList());*/
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
	@RequestMapping(name="/get-data-for-edit", method  = { RequestMethod.POST })
	public List<ComputingProjectModel> editData(@RequestParam ("id") Long id)
	{
	List<ComputingProjectModel> computingProjectModel12=computeProjectRepository.detailsForEdit(id);
	return computingProjectModel12;
	}
}
