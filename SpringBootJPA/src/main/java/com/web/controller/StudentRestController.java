package com.web.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.dao.StudentRepo;
import com.web.model.Student;

@RestController
public class StudentRestController {

	@Autowired
	StudentRepo repo;
	
//	@RequestMapping("/")
//    public String FetchData() {
//    	return "read.jsp";
//	}
	
	@GetMapping(path="/students")// to accept xml format then use this code produces= {"application/xml"})
	public List<Student> getStudents() {
		
    	return repo.findAll();
	}
	
	@GetMapping("/student/101")
	public Optional<Student> getStudent() {
		
    	return repo.findById(101);
	}
	
	@GetMapping("/student/{sid}")
	public Optional<Student> getStudent(@PathVariable("sid") int sid) {
		
    	return repo.findById(sid);
	}
	
	@PostMapping(path="/student",consumes= {"application/json"})
	public Student addStudent(@RequestBody Student student) //When you send raw data through postman here you have to mention @RequestBody
	{
		
		repo.save(student);
		return student;
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/student/{sid}")
	public String deleteStudent(@PathVariable("sid") int sid) {
		Student s=repo.getOne(sid);
		repo.delete(s);
		return "Deleted";
	}
	
	@PutMapping(path="/student",consumes= {"application/json"})
	public Student saveOrUpdateStudent(@RequestBody Student student) //When you send raw data through postman here you have to mention @RequestBody
	{
		
		repo.save(student);
		return student;
	}
}
