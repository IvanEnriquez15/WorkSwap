package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
