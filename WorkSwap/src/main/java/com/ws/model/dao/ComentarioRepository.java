package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Comentario;
@Repository
public interface ComentarioRepository  extends JpaRepository<Comentario, Long> {

}
