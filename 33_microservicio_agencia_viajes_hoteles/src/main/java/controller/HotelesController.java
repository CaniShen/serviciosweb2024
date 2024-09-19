package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.HotelDto;
import service.HotelesService;

@CrossOrigin("*")//(methods = {RequestMethod.GET})
@RestController
public class HotelesController {
	@Autowired
	HotelesService hotelesService;

	public HotelesController(HotelesService hotelesService) {
		super();
		this.hotelesService = hotelesService;
	}
	@GetMapping(value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelDto buscarHotelPorId(@PathVariable("id") int id) {
		return hotelesService.buscarHotelPorId(id);
	}
	@GetMapping(value = "/buscarHoteles/{localizacion}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HotelDto> buscarHotelesPorLocalizacion(@PathVariable("localizacion")String localizacion) {
		return hotelesService.buscarHotelesPorLocalizacion(localizacion);
	}
}
