package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.DocumentoRepository;
import com.ws.model.entity.Documento;

@Service
public class DocumentoService implements IDocumentoService{

	@Autowired
	private DocumentoRepository dao;
	
	@Override
	public List<Documento> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Documento documento) {
		// TODO Auto-generated method stub
		dao.save(documento);
	}

	@Override
	public Documento findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Documento> fetchWithUsers() {
		// TODO Auto-generated method stub
		return dao.fetchWithUsers();
	}

	@Override
	public Documento fetchByIdWithComentario(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithComentario(id);
	}

}
