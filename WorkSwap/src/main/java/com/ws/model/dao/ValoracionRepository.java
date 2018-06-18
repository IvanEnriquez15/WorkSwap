package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Valoracion;
@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

}
