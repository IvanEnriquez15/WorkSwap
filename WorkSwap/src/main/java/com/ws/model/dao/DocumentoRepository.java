package com.ws.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	@Query("select d from Documento d left join fetch d.users u")
	public List<Documento> fetchWithUsers();
	
	@Query("select d from Documento d left join fetch d.comentarios c where d.id=?1")
	public Documento fetchByIdWithComentario(Long id);
	
	//@Query("select d from Documento d left join fetch d.comentarios c where d.id=?1")
	//public Documento fetchByIdWithCuentas(Long id);
}
