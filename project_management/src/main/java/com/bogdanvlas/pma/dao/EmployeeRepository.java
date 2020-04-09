package com.bogdanvlas.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bogdanvlas.pma.dto.EmployeeProject;
import com.bogdanvlas.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, 
			value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pje.employee_id) as projectCount "
					+ "FROM EMPLOYEE e "
					+ "LEFT JOIN PROJECT_EMPLOYEE pje ON pje.EMPLOYEE_ID = e.employee_id "
					+ "GROUP BY e.first_name, e.last_name "
					+ "ORDER BY projectCount DESC") //using query that is specific to the database
	public List<EmployeeProject> employeeProjects();
}
