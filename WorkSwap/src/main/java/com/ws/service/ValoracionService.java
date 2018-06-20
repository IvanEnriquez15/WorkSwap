package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.ValoracionRepository;
import com.ws.model.entity.Documento;
import com.ws.model.entity.Users;
import com.ws.model.entity.Valoracion;

@Service
public class ValoracionService implements IValoracionService{

	@Autowired
	private ValoracionRepository dao;
	
	@Override
	public List<Valoracion> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Valoracion valoracion) {
		// TODO Auto-generated method stub
		dao.save(valoracion);
	}

	@Override
	public Valoracion findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Valoracion findByUsersAndDocumento(Users u, Documento d) {
		// TODO Auto-generated method stub
		return dao.findByUsersAndDocumento(u, d);
	}

	@Override
	public List<Valoracion> findByDocumento(Documento d) {
		// TODO Auto-generated method stub
		return dao.findByDocumento(d);
	}

	

}
