package com.ws.service;

import java.util.List;

import com.ws.model.entity.Documento;

public interface IDocumentoService {
	public List<Documento> findAll();

	public void save(Documento documento);

	public Documento findById(Long id);

	public void deleteById(Long id);
	
	public List<Documento> fetchWithUsers();
	
	public Documento fetchByIdWithComentario(Long id);
}
