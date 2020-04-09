package com.bogdanvlas.pma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bogdanvlas.pma.dao.EmployeeRepository;
import com.bogdanvlas.pma.dao.ProjectRepository;
import com.bogdanvlas.pma.entities.Employee;
import com.bogdanvlas.pma.entities.Project;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	ProjectRepository projRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	//automatically add data to database
/*	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			Employee emp1 = new Employee("Bogdan", "Vlas", "bv@gmail.com");
			Employee emp2 = new Employee("Mihai", "Popescu", "mpop@gmail.com");
			Employee emp3 = new Employee("Stefan", "Sabo", "sabo@gmail.com");

			Employee emp4 = new Employee("Cornel", "Dinu", "cornel@gmail.com");
			Employee emp5 = new Employee("Dacian", "Ciolos", "dc@gmail.com");
			Employee emp6 = new Employee("Ludovic", "Orban", "orbany@gmail.com");

			Employee emp7 = new Employee("Mirel", "Radoi", "mirel@gmail.com");
			Employee emp8 = new Employee("Adriana", "Popescu", "ad.po@gmail.com");
			Employee emp9 = new Employee("Ioana", "Rodica", "io@gmail.com");

			
			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
					+ "the final deployment of the software into production");
			Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
					+ "for the year and figureout who will be promoted");
			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
					+ "security needs to be improved and proper security team needs to be hired for "
					+ "implementation");
			
			
			
			// need to set both sides of the relationship manually

			pro1.addEmployee(emp1);
			pro1.addEmployee(emp2);
			pro2.addEmployee(emp3);
			pro3.addEmployee(emp1);
			pro4.addEmployee(emp1);
			pro4.addEmployee(emp3);

			
			// need to set both sides of the relationship manually

			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
			emp2.setProjects(Arrays.asList(pro1));
			emp3.setProjects(Arrays.asList(pro2, pro4));
			
			// save employees in database

			empRepo.save(emp1);
			empRepo.save(emp2); 
			empRepo.save(emp3); 
			empRepo.save(emp4);
			empRepo.save(emp5); 
			empRepo.save(emp6); 
			empRepo.save(emp7); 
			empRepo.save(emp8); 
			empRepo.save(emp9);

			
			// save projects in database

			projRepo.save(pro1);
			projRepo.save(pro2); 
			projRepo.save(pro3); 
			projRepo.save(pro4);		
		};
	} */

}
