package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Favorito;
@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

}
