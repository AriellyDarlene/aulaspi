package ifrn.pi.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosControllers {
	
	@Autowired
	private EventoRepository er;

	@RequestMapping("/eventos/form")
	public String form() {
		return "formEvento";
	}
	
	@PostMapping("/eventos")
	public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
		return "evento-adicionado";
	}
	
	@RequestMapping("/eventos/submit")
	public String submit(Evento evento) {
		System.out.println("O método foi executado");
		System.out.println(evento.getNome());
		System.out.println(evento.getLocal());
		System.out.println(evento.getData());
		System.out.println(evento.getHorario());
		return "ExecutandoSubmit";
	}
}
