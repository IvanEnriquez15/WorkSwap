package com.ws.service;

import java.util.List;


import com.ws.model.entity.Categoria;


public interface ICategoriaService {
	public List<Categoria> findAll();

	public void save(Categoria categoria);

	public Categoria findById(Long id);

	public void deleteById(Long id);

}
