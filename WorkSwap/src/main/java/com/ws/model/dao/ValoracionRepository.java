package com.ws.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Documento;
import com.ws.model.entity.Users;
import com.ws.model.entity.Valoracion;
@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
	
	public Valoracion findByUsersAndDocumento(Users u,Documento d);
	
	public List<Valoracion> findByDocumento(Documento d);
	
}
