package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.ReservaDto;
import service.ReservasService;

@CrossOrigin("*")//(methods = {RequestMethod.GET})
@RestController
public class ReservasController {
	@Autowired
	ReservasService reservasService;

	public ReservasController(ReservasService reservasService) {
		super();
		this.reservasService = reservasService;
	}
	@GetMapping(value="/buscar/{usuario}" , produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<ReservaDto> buscarPorUsuario(@PathVariable("usuario") String usuario){
		return reservasService.buscarPorUsuario(usuario);
	}
	@PostMapping(value = "alta" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaReserva(@RequestBody ReservaDto reserva) {
		reservasService.altaReserva(reserva);
	}
}
