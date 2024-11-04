package ifrn.pi.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosControllers {
	
	@Autowired
	private EventoRepository er;

	@GetMapping("/form")
	public String form() {
		return "eventos/formEvento";
	}
	
	@PostMapping
	public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
		return "home";
	}
	
	@GetMapping
	public ModelAndView listar() {
		
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}

}


//	@RequestMapping("/eventos/submit") public String submit(Evento evento) { System.out.println("O método foi executado"); System.out.println(evento.getNome()); 	System.out.println(evento.getLocal()); 	
// System.out.println(evento.getData()); System.out.println(evento.getHorario()); return "ExecutandoSubmit"; }


	
	
