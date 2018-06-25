package com.ws.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.model.entity.Comentario;
import com.ws.service.IComentarioService;

@RestController
@RequestMapping(value = "come")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioRest {
	@Autowired
	private IComentarioService comentarioService;

	@GetMapping
	public ResponseEntity<List<Comentario>> allComentarios() {
		List<Comentario> Comentarios = new ArrayList<>();
		try {
			Comentarios= comentarioService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Comentario>>(Comentarios, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Comentario>>(Comentarios, HttpStatus.OK);
	}
}
