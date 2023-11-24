package springmvcProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvcProject.dao.Student_dao;
import springmvcProject.dto.Student_dto;

@org.springframework.stereotype.Controller
public class Controller 
{
	@Autowired
	Student_dao dao;
	
	
	@RequestMapping("/hello")
	public void check(HttpServletResponse resp) throws IOException
	{
		PrintWriter pw =resp.getWriter();
		pw.println("hello world");
	}
	
	@RequestMapping("/signup")
	public ModelAndView sign()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("signup.jsp");
		view.addObject("student_dto",new Student_dto() );
		
		return view;
		
	}
	
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student_dto stu)
	{
		dao.saveStudent(stu);
		ModelAndView view = new ModelAndView();
		view.setViewName("index.jsp");
		return view;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		Student_dto existstu=dao.findByEmail(email);
		if(existstu!=null)
		{
			if(existstu.getStudentPassword().equals(password))
			{
				// session.setAttribute("studentname",studentname);
				
				
				ModelAndView view = new ModelAndView();
				view.addObject("students", dao.findAll());
				view.setViewName("display.jsp");
				return view;
			}
			return new ModelAndView("login.jsp");
		}
		return  new ModelAndView("login.jsp");
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
			dao.deleteStudent(id);
			ModelAndView view = new ModelAndView();
			view.addObject("students", dao.findAll());
			view.setViewName("display.jsp");
		    return view;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editStudent(@RequestParam int id)
	{
		Student_dto existstu=dao.findStudent(id);
		ModelAndView view = new ModelAndView();
		view.addObject(existstu);
		view.setViewName("edit.jsp");
		return view;
		
	}
	@RequestMapping("/update")
	public ModelAndView updateStudent(@ModelAttribute Student_dto stu)
	{
		dao.updateStudent(stu, stu.getStudent_id());
		ModelAndView view = new ModelAndView();
		view.addObject("students", dao.findAll());
		view.setViewName("display.jsp");
		return view;
		
	}

	
	
	
	
	
	
	     
}
