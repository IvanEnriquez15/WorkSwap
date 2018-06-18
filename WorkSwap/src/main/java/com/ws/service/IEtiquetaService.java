package com.ws.service;

import java.util.List;

import com.ws.model.entity.Etiqueta;

public interface IEtiquetaService {
	public List<Etiqueta> findAll();

	public void save(Etiqueta etiqueta);

	public Etiqueta findById(Long id);

	public void deleteById(Long id);
}
