package com.example.demo.controller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.model.ComputingProjectModel;
import com.example.demo.restApiController.ComputingProjectRestApiController;

@Controller
@RequestMapping("/home")
public class ComputingProjectController {

	@Autowired
	private ComputingProjectRestApiController computingProjectRestApiController;

	@Autowired
	String apiURL;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * public ComputingProjectController(ComputingProjectConifg
	 * computingProjectConifg) { this.apiURL = computingProjectConifg.getApiURL(); }
	 */

	@GetMapping("/computingProject")
	public String getdata(Model model, @ModelAttribute ComputingProjectModel comp) {

		if (comp.getMessage() != null) {
			model.addAttribute("savingConformation", comp.getMessage());
		}
		ResponseEntity<ComputingProjectModel> user1 = restTemplate.postForEntity(apiURL + "/myHome/getDetails", null,
				ComputingProjectModel.class);
		// List<ComputingProjectModel> user =
		// computingProjectRestApiController.getDetails();
		ComputingProjectModel user = user1.getBody();

		model.addAttribute("com", user);
		return "computingProject";
	}

	@GetMapping("/computing-project-save-data")
	public String postData(@ModelAttribute ComputingProjectModel comp, RedirectAttributes redirectAttributes)
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
