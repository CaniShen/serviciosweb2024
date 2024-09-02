package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Ficha;
@Path("/informacion")
public class InfoController {
	@GET //el método se ejecutará con peticiones get
	@Path("/ficha")// en caso se va a ejecutar
	@Produces(MediaType.APPLICATION_JSON)//TEXT ,XML, JSON, EN ESTE CASO ES TEXTO PLANO
	public Ficha fichaProducto() {
		return new Ficha("pc",800,"informacion");
	}
}
