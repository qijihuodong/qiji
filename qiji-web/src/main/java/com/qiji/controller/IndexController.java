package com.qiji.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

	@RequestMapping({"/","/index.html","index"})
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	@RequestMapping(value={"/register.html","register"},method=RequestMethod.GET)
	public ModelAndView register(){
		return new ModelAndView("register");
	}
	@RequestMapping(value={"/forget.html","forget"},method=RequestMethod.GET)
	public ModelAndView forget(){
		return new ModelAndView("forget");
	}
	
	@RequestMapping(value={"/about.html","about"},method=RequestMethod.GET)
	public ModelAndView about(){
		return new ModelAndView("about");
	}
	
	@RequestMapping(value={"/require.html","require"},method=RequestMethod.GET)
	public ModelAndView require(){
		return new ModelAndView("require");
	}
	
	@RequestMapping(value={"/requireXQ.html","requireXQ"},method=RequestMethod.GET)
	public ModelAndView requireXQ(){
		return new ModelAndView("requireXQ");
	}
	
	@RequestMapping(value={"/serviceXQ.html","serviceXQ"},method=RequestMethod.GET)
	public ModelAndView serviceXQ(){
		return new ModelAndView("serviceXQ");
	}
}
