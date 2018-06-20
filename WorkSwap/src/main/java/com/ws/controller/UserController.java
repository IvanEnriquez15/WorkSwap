package com.ws.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ws.model.entity.Users;
import com.ws.service.IUserService;


@Controller
@SessionAttributes("user")
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping(value = "/new")
	public String newCustomer(Model model) {

		Users users = new Users();
		model.addAttribute("users", users);
		//model.addAttribute("title", "New User");
		return "user/form";
	}

	@PostMapping(value = "/save")
	public String saveCustomer(@Valid Users users, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Save User");
			return "user/form";
		}

		String mensajeFlash = (users.getId() != null) ? "Successfully edited client!"
				: "Customer created successfully!";

		userService.save(users);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/login";
	}

	@GetMapping(value = "/edit/{id}")
	public String editCustomer(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Users users = null;

		if (id > 0) {
			users = userService.findById(id);
			if (users == null) {
				flash.addFlashAttribute("error", "The customer ID does not exist in the database!");
				return "redirect:/documento/list";
			}
		} else {
			flash.addFlashAttribute("error", "The customer ID can not be zero!");
			return "redirect:/user/";
		}
		model.addAttribute("users", users);
		model.addAttribute("title", "Edit Customer");
		return "user/form";
	}

	
	@GetMapping(value = "/delete/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {

			userService.deleteById(id);
			flash.addFlashAttribute("success", "Customer removed successfully!");
		}
		return "redirect:/documento/list";
	}

	/*
	@GetMapping(value = "/detail/{id}")
	public String detailsCustomer(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Customer customer = customerService.findById(id);
		if (customer == null) {
			flash.addFlashAttribute("error", "The client does not exist in the database");
			return "redirect:/customer/list";
		}

		model.addAttribute("customer", customer);
		model.addAttribute("title", "Customer");
		return "customer/detail";
	}*/
}
