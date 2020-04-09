package com.bogdanvlas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bogdanvlas.pma.dao.EmployeeRepository;
import com.bogdanvlas.pma.dao.ProjectRepository;
import com.bogdanvlas.pma.entities.Employee;
import com.bogdanvlas.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {  // method for saving to database
		
		proRepo.save(project);
		
		
		//redirect is used here to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	//show only projects page list
		@GetMapping
		public String displayProjectsList(Model model) {
			List<Project> projects = proRepo.findAll();
			model.addAttribute("projectsList", projects);
			
			return "projects/projects-list";
		}
		
}
