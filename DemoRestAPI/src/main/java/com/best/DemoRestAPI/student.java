package com.best.DemoRestAPI;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class student {
    
	String student_name;
	int   student_rollno;
	int student_class;
	String student_collage;
	String student_branch;
	
	@Override
	public String toString() {
		return "student [student_name=" + student_name + ", student_rollno=" + student_rollno + ", student_class="
				+ student_class + ", student_collage=" + student_collage + ", student_branch=" + student_branch + "]";
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_rollno() {
		return student_rollno;
	}
	public void setStudent_rollno(int student_rollno) {
		this.student_rollno = student_rollno;
	}
	public int getStudent_class() {
		return student_class;
	}
	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}
	public String getStudent_collage() {
		return student_collage;
	}
	public void setStudent_collage(String student_collage) {
		this.student_collage = student_collage;
	}
	public String getStudent_branch() {
		return student_branch;
	}
	public void setStudent_branch(String student_branch) {
		this.student_branch = student_branch;
	}
	
	
	
	
	
	
}
