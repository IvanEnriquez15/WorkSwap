package com.ws.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ws.model.entity.Users;
import com.ws.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userService;
	
	
	@GetMapping(value = "/login")
	public String Login(Model model) {

		Users users = new Users();
		model.addAttribute("users", users);
		return "index";
	}
	
	@PostMapping(value = "/login")
	public String Log_in(@Valid Users users, BindingResult result, Model model, SessionStatus status) {

		String username = users.getUsername();
		String password = users.getPassword();
		
		Users userValidado = userService.findByUsernameAndPassword(username, password);
		
		/*if (result.hasErrors()) {
			return "index";
		}*/	
		if(userValidado.getId()==null) {
			Users usrs = new Users();
			model.addAttribute("users", usrs);
			return "index";
			
		}
		
		status.setComplete();
		return "redirect:/documento/list/" +userValidado.getId();
		
	}
}
