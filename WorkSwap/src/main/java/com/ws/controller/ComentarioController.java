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

import com.ws.model.entity.Comentario;
import com.ws.service.IComentarioService;

@Controller
@SessionAttributes("comentario")
@RequestMapping("/comentario/")
public class ComentarioController {
	@Autowired
	private IComentarioService documentoService;
	
	@PostMapping(value = "/save")
	public String saveCliente(@Valid Comentario comentario, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "documento/form";
		}	
		
		documentoService.save(comentario);
		status.setComplete();
		return "redirect:/documento/detalle/"+comentario.getDocumento().getId();
		
	}
}
