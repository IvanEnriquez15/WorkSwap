package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Etiqueta;
@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

}
