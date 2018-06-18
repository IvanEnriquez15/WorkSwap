package com.ws.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ws.model.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
	public Users findByUsernameAndPassword(String username,String password);
	
	@Query("select u from Users u left join fetch u.documentos d where u.id=?1")
	public Users fetchByIdWithDocumentos(Long id);
	
	@Query("select u from Users u left join fetch u.favoritos f where u.id=?1")
	public Users fetchByIdWithFavoritos(Long id);
}
