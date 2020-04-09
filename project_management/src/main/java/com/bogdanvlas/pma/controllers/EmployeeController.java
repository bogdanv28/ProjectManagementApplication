package com.bogdanvlas.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bogdanvlas.pma.dao.EmployeeRepository;
import com.bogdanvlas.pma.entities.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/newemp")
	public String displayEmployeeForm(Model model) {
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);

		return "employees/new-employee";
	}

	@PostMapping("/saveEmp")
	public String createEmployee(Employee employee, Model model) {  // method for saving to database
		empRepo.save(employee);
		
		//redirect is used here to prevent duplicate submissions
		return "redirect:/employees/newemp";
	}
	
	//show only employees page list
	@GetMapping
	public String displayEmployeeList(Model model) {
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeeList", employees);
		
		return "employees/employees-list";
	}
	
}
