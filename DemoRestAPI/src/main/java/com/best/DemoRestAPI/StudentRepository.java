package com.best.DemoRestAPI;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class StudentRepository {

	
	
	
	Connection con = null;
	public  StudentRepository()
	{
		String url ="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="root";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con= DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<student> getStudents() 
	{
		List<student> students = new ArrayList<student>();
		String sql= "Select * from student_details";
		student s = new student();
		try {
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) 
			{
				
				s.setStudent_name(rs.getString(1));
				s.setStudent_rollno(rs.getInt(2));
				s.setStudent_class(rs.getInt(3));
				s.setStudent_collage(rs.getString(4));
				s.setStudent_branch(rs.getString(5));
				
				students.add(s);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
		
	}
	
	public student getStudent(int rollno) 
	{
		String sql= "Select * from student_details where student_rollno ="+rollno;
		student sg = new student();
	try {
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(sql);
		if(rs.next()) 
		{
			sg.setStudent_name(rs.getString(1));
			sg.setStudent_rollno(rs.getInt(2));
			sg.setStudent_class(rs.getInt(3));
			sg.setStudent_collage(rs.getString(4));
			sg.setStudent_branch(rs.getString(5));			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return sg;
	}

	public void create(student su) {
		// TODO Auto-generated method stub

		String sql= "insert into student_details values (?,?,?,?,?)";
	try {
		PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1,su.getStudent_name());
			st.setInt(2,su.getStudent_rollno());
			st.setInt(3,su.getStudent_class());
			st.setString(4,su.getStudent_collage());
			st.setString(5,su.getStudent_branch());	
			
			st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public void update(student su) {
		// TODO Auto-generated method stub
		String sql= "Update student_details set student_name =?,student_class=?,student_collage=?,student_branch=? where student_rollno =?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
			
					st.setString(1,su.getStudent_name());
					st.setInt(2,su.getStudent_class());
					st.setString(3,su.getStudent_collage());
					st.setString(4,su.getStudent_branch());	
					st.setInt(5,su.getStudent_rollno());
					
					st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	public void delete(int rollno) {
		// TODO Auto-generated method stub
		String sql="Delete from student_details where student_rollno =?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				    st.setInt(1,rollno);
					st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	
}
