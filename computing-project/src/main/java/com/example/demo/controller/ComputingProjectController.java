package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ResponseDto;
import com.example.demo.model.ComputingProjectModel;
import com.example.demo.restApiController.ComputingProjectRestApiController;

@Controller
@RequestMapping(value="/home")
public class ComputingProjectController {

	@Autowired
	private ComputingProjectRestApiController computingProjectRestApiController;

	@Autowired
	String apiURL;

	@Autowired
	private RestTemplate restTemplate;
		
	@RequestMapping(value="/computingProject")
	public String getdata(HttpServletResponse response,Model model, @ModelAttribute("comp") ComputingProjectModel comp) {

		if (comp.getMessage() != null) {
			model.addAttribute("savingConformation", comp.getMessage());
		}
		
		
		ResponseEntity<ResponseDto> response1 = restTemplate.getForEntity(apiURL+"/myHome/getDetails",ResponseDto.class);
	
		List<ComputingProjectModel> modLL= response1.getBody().getComputingProjectModelList();
	
		model.addAttribute("com", modLL);
		
		return "computingProject";
		}
	
	@GetMapping("/computing-project-save-data")
	public String postData(@ModelAttribute("comp") ComputingProjectModel comp, RedirectAttributes redirectAttributes)
			throws ParseException {
		ComputingProjectModel comp1 = computingProjectRestApiController.saveDetails(comp);

		if (comp.getEmail() != null) {
			comp.setMessage("User Details are saved successfully");
			redirectAttributes.addFlashAttribute("comp", comp);
		}
		return "redirect:/home/computingProject";
	}

	@GetMapping("/error")
	public String geterror() {

		return "error";
	}
	

}
