package com.cmpe275.Lab2.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.cmpe275.Lab2.model.Address;
import com.cmpe275.Lab2.model.Player;
import com.cmpe275.Lab2.service.PlayersService;
import com.cmpe275.Lab2.service.SponsorService;


@RestController
public class ApplicationController {
	
	@Autowired
	private PlayersService playersService;
	
	@Autowired
	private SponsorService sponsorService;

	@GetMapping("/hello")
	public String hello(){
		return "Hello World!!!";
	}
	
	
	@PostMapping("/player")
	public ModelAndView cratePlayer(@RequestParam(value="firstname", required=true) String firstname, 
			@RequestParam(value="lastname", required=true) String lastname, 
			@RequestParam(value="email", required=true) String email, 
			@RequestParam(value="description", required=false) String description, 
			@RequestParam(value="street", required=false) String street,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="state", required=false) String state,
			@RequestParam(value="zip", required=false) Long zip,
			@RequestParam(value="id", required=false) int sponsorerId){
		
		ModelMap map = new ModelMap();
		map.addAttribute("creteplayers",PlayersService.addPlayers(firstname,lastname,email,description,street,city,state,zip,sponsorerId));
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}
	/*@DeleteMapping("/player/{Id}")*/
	
	/*@GetMapping("/alltasks")
	public ModelAndView allTasks(){
		ModelMap map = new ModelMap();
		map.addAttribute("tasks",taskService.findAll());
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}*/
//	
//	@GetMapping("/save-task")
//	public String saveTask(@RequestParam String name, @RequestParam String desc){
//		Task task = new Task(name, desc, new Date(), false);
//		taskService.save(task);
//		return "Task saved!";
//	}
//	
//	@GetMapping("/delete-task")
//	public String saveTask(@RequestParam int id){
//		taskService.delete(id);
//		return "Task deleted!";
//	}
}
