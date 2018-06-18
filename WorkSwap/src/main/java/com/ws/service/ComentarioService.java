package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.ComentarioRepository;
import com.ws.model.entity.Comentario;

@Service
public class ComentarioService implements IComentarioService{

	@Autowired
	private ComentarioRepository dao;
	
	@Override
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Comentario comentario) {
		// TODO Auto-generated method stub
		dao.save(comentario);
	}

	@Override
	public Comentario findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
