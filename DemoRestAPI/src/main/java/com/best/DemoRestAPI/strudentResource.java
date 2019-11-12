package com.best.DemoRestAPI;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class strudentResource {

	
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<student> getStudents() 
	{
		System.out.println("GetStudents Calling");		
		return repo.getStudents();
		
	}
	

	@GET
	@Path("student/{rollno}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public student getStudent(@PathParam("rollno") int rollno) 
	{
		System.out.println("Single Student Calling");		
		return repo.getStudent(rollno);
	}
	
	@POST
	@Path("student")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public student createStudent(student s) 
	{   
		System.out.println(s);	
		repo.create(s);
		return s;
	}
	
	@PUT
	@Path("student")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public student updateStudent(student s) 
	{   
		System.out.println(s);	
		if(repo.getStudent(s.getStudent_rollno()).getStudent_rollno()==0)
		{
			repo.create(s);
		}
		else {
			repo.update(s);	
		}
		
		return s;
	}
	
	@DELETE
	@Path("student/{rollno}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public student deleteStudent(@PathParam("rollno") int rollno) 
	{   
		student s	=repo.getStudent(rollno);
		if (s.getStudent_rollno()!=0) 
		{
			repo.delete(rollno);
		}
		return s;
	}
}
