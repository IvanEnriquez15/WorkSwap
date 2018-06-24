package com.ws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ws.model.entity.Users;
import com.ws.service.IUserService;

@Controller
@SessionAttributes("favorito")
@RequestMapping("/favorito/")
public class FavoritoController {
		
	@Autowired
	private IUserService userService;
		
	@GetMapping(value = "/list/{id}")
	public String listDocumento(@PathVariable(value = "id") Long id,Model model) {
		
		Users users = userService.fetchByIdWithFavoritos(id);
		
		model.addAttribute("favoritos",users.getFavoritos());
		model.addAttribute("users",users);
		
		return "favorito/list";
	}
}
