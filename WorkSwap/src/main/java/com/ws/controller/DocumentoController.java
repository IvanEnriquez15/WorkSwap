package com.ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ws.model.entity.Comentario;
import com.ws.model.entity.Documento;
import com.ws.model.entity.Favorito;
import com.ws.model.entity.Users;
import com.ws.model.entity.Valoracion;
import com.ws.service.IDocumentoService;
import com.ws.service.IFavoritoService;
import com.ws.service.IUserService;
import com.ws.service.IValoracionService;


@Controller
@SessionAttributes("documento")
@RequestMapping("/documento/")
public class DocumentoController {

	@Autowired
	private IDocumentoService documentoService;
	
	@Autowired
	private IValoracionService valoracionService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IFavoritoService favoritoService;
	
	private Users users;
	
	
	@GetMapping(value = "/list/{id}")
	public String listDocumento(@PathVariable(value = "id") Long id,Model model) {
		
		
		users = userService.findById(id);
		
		model.addAttribute("documentos",documentoService.fetchWithUsers());
		model.addAttribute("users",users);
		
		return "documento/list";
	}

	@GetMapping(value = "/list/")
	public String listDocumento(Model model) {
		
		Users us = userService.fetchByIdWithDocumentos(users.getId());
		
		model.addAttribute("documentos",us.getDocumentos());
		model.addAttribute("users",us);
		
		return "documento/list";
	}
	
	@GetMapping(value = "/new")
	public String newDocumento(Model model) {
		
		Documento documento = new Documento();
		documento.setUsuario(users);
		
		model.addAttribute("users", users);
		model.addAttribute("documento", documento);		
		return "documento/form";
	}

	@PostMapping(value = "/save")
	public String saveDocumento(@Valid Documento documento, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "documento/form";
		}	

		documentoService.save(documento);
		status.setComplete();
		return "redirect:/documento/list/"+documento.getUsuario().getId();
		
	}
	
	
	@GetMapping(value = "/delete/{id}")
	public String deleteDocumento(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {

			documentoService.deleteById(id);
			flash.addFlashAttribute("success", "Documento removed successfully!");
		}
		return "redirect:/documento/list";
	}
	
	
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable(value = "id") Long id,Model model) {
		
		Comentario comentario = new Comentario();
		Users u = userService.findById(users.getId());
		Documento doc = documentoService.findById(id);
		comentario.setDocumento(doc);
		comentario.setUsuario(u);
		double promedio = HallarPromedioValoracion(doc);
		doc.setValoracion(promedio);
		
		
		Valoracion var =new Valoracion();		
		var=valoracionService.findByUsersAndDocumento(users, doc);
		if(var==null) {
			var=new Valoracion();
			var.setUsuario(users);
			var.setDocumento(doc);
		}
		
		model.addAttribute("users",u);	
		model.addAttribute("comentarios",doc.getComentarios());
		model.addAttribute("documento",doc);				
		model.addAttribute("comentario", comentario);
		model.addAttribute("valoracion", var);
		return "documento/detalle";	
	}
	
	@GetMapping("/favorito/{id}")
	public String AgregarFavorito(@PathVariable(value = "id") Long id,Model model) {
		
		Documento doc = documentoService.findById(id);		
		
		Favorito fav =new Favorito();
		fav.setUsuario(users);
		fav.setDocumento(doc);
		
		favoritoService.save(fav);
		
		return "redirect:/documento/list/"+users.getId();	
	}
	
	
	
	private double HallarPromedioValoracion(Documento d) {
		double promedio =0;
		
		List<Valoracion> valores =  valoracionService.findByDocumento(d);
		for (Valoracion v :valores) {
			promedio +=v.getNota();
		}
		
		
		return  promedio/valores.size();
	}
}
