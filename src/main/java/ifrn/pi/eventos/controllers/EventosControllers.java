package ifrn.pi.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.eventos.models.Evento;

@Controller
public class EventosControllers {

	@RequestMapping("/eventos/form")
	public String form() {
		return "formEvento";
	}
	
	public String adicionar() {
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
