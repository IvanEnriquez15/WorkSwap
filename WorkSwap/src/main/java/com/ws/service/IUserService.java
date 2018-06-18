package com.ws.service;

import java.util.List;

import com.ws.model.entity.Users;

public interface IUserService {
	public List<Users> findAll();

	public void save(Users users);

	public Users findById(Long i);

	public void deleteById(Long id);
	
	public Users findByUsernameAndPassword(String username,String password);
	
	public Users findByUsername(String username);
	
	public Users fetchByIdWithDocumentos(Long id);
	
	public Users fetchByIdWithFavoritos(Long id);
}
