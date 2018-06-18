package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.FavoritoRepository;
import com.ws.model.entity.Favorito;

@Service
public class FavoritoService implements IFavoritoService{

	@Autowired
	private FavoritoRepository dao;
	
	@Override
	public List<Favorito> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Favorito favorito) {
		// TODO Auto-generated method stub
		dao.save(favorito);
	}

	@Override
	public Favorito findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
