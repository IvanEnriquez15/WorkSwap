package com.ws.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="documentos")
public class Documento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NotNull
	private String ciclo;

	@NotNull
	private String descripcion;

	@NotNull
	private double valoracion;

	@ManyToOne(fetch=FetchType.LAZY)
	private Users users;

	
	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Valoracion> valoraciones;
	
	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Favorito> favoritos;
	
	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Etiqueta> etiquetas;

	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
		valoracion=4;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_publicacion() {
		return fecha;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha = fecha_publicacion;
	}


	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public Users getUsuario() {
		return users;
	}

	public void setUsuario(Users usuario) {
		this.users = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
	public List<Favorito> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
	
}
