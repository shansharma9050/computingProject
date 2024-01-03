package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ResponseDto;
import com.example.demo.model.ComputingProjectModel;
import com.example.demo.model.DataComputingModel;
import com.example.demo.restApiController.DataComputingRestController;

@Controller
@RequestMapping("/home/*")
public class DataComputingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	DataComputingRestController dataComputingRestController;
	
	@Autowired
	private String apiURL;
	@GetMapping("/getdata")
	public String getDataComputing(Model model,@ModelAttribute("dataComputingModel")  DataComputingModel dataComputingModel)
	{
	if(dataComputingModel.getMessage()!=null)
	{
		model.addAttribute("savingConformation", dataComputingModel.getMessage());
	}
	
	List<DataComputingModel> dataComputingModelList=dataComputingRestController.getData();
	
	model.addAttribute("dataComputingModelList", dataComputingModelList);
	
	
	ResponseEntity<ResponseDto> response1 = restTemplate.getForEntity(apiURL+"/myHome/getDetails",ResponseDto.class);
	
	List<ComputingProjectModel> modLL= response1.getBody().getComputingProjectModelList();

	model.addAttribute("com", modLL);
	
		return "data_computing";

	}

	@GetMapping("/setdata")
	public ResponseEntity<String> myMethod()
	{
		String body;
		return ResponseEntity.ok(body="Welcome to the page setdata");
	}
	
	
	 @PostMapping("/submit-all-details-of-user")
	 public String postDataComputing(@ModelAttribute("dataComputingModel") DataComputingModel dataComputingModel,RedirectAttributes redirectAttributes) 
	 {
		 
	 //DataComputingModel resEnt=restTemplate.postForObject(apiUrl +"/homes/save-data-computing-details", dataComputingModel, DataComputingModel.class);
		 DataComputingModel resEnt= dataComputingRestController.saveData(dataComputingModel);
	 if(dataComputingModel.getName()!=null) {
	 dataComputingModel.setMessage("User Details are saved successfully");
	 redirectAttributes.addFlashAttribute("dataComputingModel",dataComputingModel);
	 }
	 return "redirect:/home/getdata"; 
	 
	 
	 }
	

}
