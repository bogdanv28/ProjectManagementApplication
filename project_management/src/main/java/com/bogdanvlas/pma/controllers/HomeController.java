package com.bogdanvlas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bogdanvlas.pma.dao.EmployeeRepository;
import com.bogdanvlas.pma.dao.ProjectRepository;
import com.bogdanvlas.pma.dto.ChartData;
import com.bogdanvlas.pma.dto.EmployeeProject;
import com.bogdanvlas.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	//without spring, the implementation will be manually, with anonymous class: 
	//ProjectRepository proRepo = new ProjectRepository() {
	//  with methods here
	//}
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		//to get data for chart
		List<ChartData> projectData = proRepo.getProjectsStatus();
		
		//converting projectData into json structure for javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCount", jsonString);
		
		
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectsCount", employeesProjectCount);
		
		return "main/home";
	}
	
}
