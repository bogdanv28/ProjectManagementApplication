package com.bogdanvlas.pma.dto;

public interface EmployeeProject {

	//must have the property names begin with get, that's how spring knows that this 
	//data transfer object needs to be used to populate with the data that is comming from query
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();
}
