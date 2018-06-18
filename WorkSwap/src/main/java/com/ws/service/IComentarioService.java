package com.ws.service;

import java.util.List;

import com.ws.model.entity.Comentario;

public interface IComentarioService {
	public List<Comentario> findAll();

	public void save(Comentario comentario);

	public Comentario findById(Long id);

	public void deleteById(Long id);
}
