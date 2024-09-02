package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas") //primera anotación de jax rest
public class SaludoController {
	@GET //el método se ejecutará con peticiones get
	@Path("/saludar")// en caso se va a ejecutar
	@Produces(MediaType.TEXT_PLAIN)//TEXT ,XML, JSON, EN ESTE CASO ES TEXTO PLANO
	public String getSaludo() {
		return "Bienvenido a mi servicio REST";
	}
	@GET //el método se ejecutará con peticiones get
	@Path("/saludar/{name}")//la variable viene como un nombre//HTTP:LOCALHOST:8080/01_ejemplo_rest/servicio/pruebas/saludar/---/---
	@Produces(MediaType.TEXT_PLAIN)//http://localhost:8080/01_ejemplo_rest/pruebas/saludar/cani
	public String getSaludoPersonal(@PathParam("name") String nombre) {
		return "Bienvenido a mi servicio REST,sr./a."+nombre;
	}
	@GET //el método se ejecutará con peticiones get
	@Path("/info")//la variable viene como un nombre//HTTP:LOCALHOST:8080/01_ejemplo_rest/servicio/pruebas/saludar/---/---
	@Produces(MediaType.TEXT_PLAIN) //http://localhost:8080/01_ejemplo_rest/pruebas/info?name=profe&age=12
	public String getInfo(@QueryParam("name") String nombre, @QueryParam("age") int edad) {
		return "te llamas "+nombre+" y tienes "+edad+" años ";
	}
}
