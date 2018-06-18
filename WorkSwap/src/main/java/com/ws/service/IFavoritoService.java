package com.ws.service;

import java.util.List;

import com.ws.model.entity.Favorito;

public interface IFavoritoService {
	public List<Favorito> findAll();

	public void save(Favorito favorito);

	public Favorito findById(Long id);

	public void deleteById(Long id);
}
