package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.UserRepository;
import com.ws.model.entity.Users;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository dao;
	
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Users users) {
		// TODO Auto-generated method stub
		dao.save(users);
	}

	@Override
	public Users findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Users findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public Users fetchByIdWithDocumentos(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithDocumentos(id);
	}

	@Override
	public Users fetchByIdWithFavoritos(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithFavoritos(id);
	}

}
