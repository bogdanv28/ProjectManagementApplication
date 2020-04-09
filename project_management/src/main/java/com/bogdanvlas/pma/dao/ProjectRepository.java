package com.bogdanvlas.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bogdanvlas.pma.dto.ChartData;
import com.bogdanvlas.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, 
			value = "SELECT STAGE AS LABEL, COUNT(*) AS VALUE " + 
					"FROM PROJECT " + 
					"GROUP BY STAGE") //using query that is specific to the database
	public List<ChartData> getProjectsStatus();
}
