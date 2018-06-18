package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.CategoriaRepository;
import com.ws.model.entity.Categoria;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	private CategoriaRepository dao;
	
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		dao.save(categoria);
	}

	@Override
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
