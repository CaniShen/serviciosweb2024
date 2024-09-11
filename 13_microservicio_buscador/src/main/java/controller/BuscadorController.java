package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.ResultadoDto;
import service.BuscadorService;
@CrossOrigin("*")
@RestController
public class BuscadorController {
	@Autowired
	@Qualifier("buscadorEstandar")
	BuscadorService buscadorService;

	public BuscadorController(BuscadorService buscadorService) {
		super();
		this.buscadorService = buscadorService;
	}
	@PostMapping(value="alta",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String alta (@RequestBody ResultadoDto resultado) {
		System.out.println("!!!!!!!!!!!!!!!!alta de "+resultado.getUrl());
		return String.valueOf(buscadorService.agregar(resultado));
	}
	@GetMapping(value="/buscar/{tematica}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ResultadoDto> buscarPorTematica(@PathVariable("tematica")String tematica) {
	
		return buscadorService.buscar(tematica);
	
	}
	@GetMapping(value="/buscar/{url}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultadoDto buscarPorUrl(@PathVariable("url")String url) {
		return buscadorService.buscarPorUrl(url);
	}

}
