package com.ws.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.model.entity.Users;
import com.ws.service.IUserService;

@RestController
@RequestMapping(value = "usu")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersRest {
	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<Users>> allUsers() {
		List<Users> Users = new ArrayList<>();
		try {
			Users= userService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Users>>(Users, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Users>>(Users, HttpStatus.OK);
	}
}
