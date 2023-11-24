package springmvcProject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Entity
@Component
@Scope("prototype")
public class Student_dto
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	private String studentname;
	private String studentemail;
	private String StudentPassword;
	private long studentcontact;
	
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public String getStudentPassword() {
		return StudentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}
	public long getStudentcontact() {
		return studentcontact;
	}
	public void setStudentcontact(long studentcontact) {
		this.studentcontact = studentcontact;
	}
	
	

}
