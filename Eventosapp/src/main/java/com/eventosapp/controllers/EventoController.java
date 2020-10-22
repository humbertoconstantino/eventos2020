package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Evento;
import com.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	EventoRepository er;
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "form";
	}
	@PostMapping("/cadastrar")
	public String cadastrar(Evento evento) {
		er.save(evento);
		return "redirect:/cadastrar";
	}
	@RequestMapping("/listar")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("lista");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
}
