package com.ws.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ws.model.entity.Documento;
import com.ws.model.entity.Users;
import com.ws.model.entity.Valoracion;
import com.ws.service.IValoracionService;

@Controller
@SessionAttributes("valoracion")
@RequestMapping("/valoracion/")
public class ValoracionController {
	
	@Autowired
	private IValoracionService valoracionService;
	
	@PostMapping(value = "/save")
	public String saveValoracion(@Valid Valoracion valoracion, BindingResult result, Model model, SessionStatus status) {
		Users u = valoracion.getUsuario();
		Documento d=valoracion.getDocumento();
		int nota =valoracion.getNota();
		
		Valoracion valoracionNueva=valoracionService.findByUsersAndDocumento(u, d);
		
		
		if(valoracionNueva!=null) {
			valoracionNueva.setNota(nota);
			valoracionService.save(valoracionNueva);			
		}
		else {
			valoracionService.save(valoracion);
		}
		
		status.setComplete();
		return "redirect:/documento/detalle/"+valoracion.getDocumento().getId();
		
	}
}
