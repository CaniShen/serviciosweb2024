package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController// tampoco hay que hacer la confi de Controller ya que es RestController 
public class infoController {
	@GetMapping(value="info",produces = MediaType.APPLICATION_JSON_VALUE)  
	public Ficha info() {//no necesita a poner responsebody porque es RestController es implícito
		return new Ficha("pc",700,"Informática");
	}

}
