package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.VueloDto;
import service.VuelosService;

@CrossOrigin("*")//(methods = {RequestMethod.GET})
@RestController
public class VuelosController {
	@Autowired
	VuelosService vuelosService;

	public VuelosController(VuelosService vuelosService) {
		super();
		this.vuelosService = vuelosService;
	}
	
	@GetMapping(value = "/buscarvuelos/{plazas}/{destino}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VueloDto> buscarVuelosPorDestinoPlazas(@PathVariable("plazas") int plazas, @PathVariable("destino") String destino){
		return vuelosService.buscarVuelosPorPlazasDestino(plazas, destino);
	}

	@PutMapping(value = "/actualizarvuelo", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean actualizarVuelo(@RequestParam("idVuelo") int idVuelo, @RequestParam ("plazas")int plazas) {
		return vuelosService.actualizarVuelo(idVuelo, plazas);
	}
	
	@GetMapping(value = "/buscarvuelo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VueloDto buscarPorId(@PathVariable("id")int id) {
		return vuelosService.buscarPorId(id);
	}
}
