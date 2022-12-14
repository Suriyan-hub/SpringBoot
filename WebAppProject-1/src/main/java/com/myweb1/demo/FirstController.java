package com.myweb1.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@RequestMapping("First")
	public String First(HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		String name=req.getParameter("name");
		System.out.println("hi" +name);
		session.setAttribute("name", name);
		return "First";
	}
	
	@RequestMapping("Second")
	public String Second(@RequestParam("name") String myName1,HttpSession session)
	{
		System.out.println("hi" +myName1);
		session.setAttribute("name", myName1);
		return "Second";
	}
	
	@RequestMapping("Third")
	public ModelAndView Third(@RequestParam("name") String myName)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("Third");
		return mv;
	}
	@RequestMapping("Fourth")
	public ModelAndView Fourth(Student stud)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj",stud);
		mv.setViewName("Fourth");
		return mv;
	}
	
}
