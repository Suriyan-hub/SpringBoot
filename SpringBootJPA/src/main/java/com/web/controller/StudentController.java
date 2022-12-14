package com.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.StudentRepo;
import com.web.model.Student;

@Controller
public class StudentController {

	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String Home() {
		return "index.jsp";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		
		repo.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("/readStudent")
	public ModelAndView readStudent(@RequestParam int sid)
	{
		//System.out.println("Inside readStudent");
		ModelAndView mv=new ModelAndView("view.jsp");
		Student student = repo.findById(sid).orElse(new Student());
//	    System.out.println(repo.findBySname("Grace"));
//		System.out.println(repo.findBySidGreaterThan(102));
//		System.out.println(repo.findBySnameStartsWith('V'));
//		System.out.println(repo.findByCourseSorted("HTML"));
		mv.addObject(student);
		return mv;
}
	
//	@RequestMapping("/students")
//	@ResponseBody
//    public String getStudents() {
//		
//    	return repo.findAll().toString();
//	}
	
}
