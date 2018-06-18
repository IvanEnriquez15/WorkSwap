package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.model.dao.EtiquetaRepository;
import com.ws.model.entity.Etiqueta;

@Service
public class EtiquetaService implements IEtiquetaService{

	@Autowired
	private EtiquetaRepository dao; 
	
	@Override
	public List<Etiqueta> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		dao.save(etiqueta);
	}

	@Override
	public Etiqueta findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
