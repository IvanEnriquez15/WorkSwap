package com.ws.service;

import java.util.List;

import com.ws.model.entity.Documento;
import com.ws.model.entity.Users;
import com.ws.model.entity.Valoracion;

public interface IValoracionService {
	public List<Valoracion> findAll();

	public void save(Valoracion valoracion);

	public Valoracion findById(Long id);

	public void deleteById(Long id);
	
	public Valoracion findByUsersAndDocumento(Users u,Documento d);
	public List<Valoracion> findByDocumento(Documento d);
}
