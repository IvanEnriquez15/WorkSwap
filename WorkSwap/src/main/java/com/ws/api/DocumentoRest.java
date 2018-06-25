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

import com.ws.service.IDocumentoService;
import com.ws.model.entity.Documento;

@RestController
@RequestMapping(value = "docu")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentoRest {

	@Autowired
	private IDocumentoService documentoService;

	@GetMapping
	public ResponseEntity<List<Documento>> allDocumentos() {
		List<Documento> documentos = new ArrayList<>();
		try {
			documentos= documentoService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Documento>>(documentos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Documento>>(documentos, HttpStatus.OK);
	}
}
