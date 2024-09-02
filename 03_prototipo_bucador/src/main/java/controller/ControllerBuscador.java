package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import service.BuscadorService;

@Path("/buscador")
public class ControllerBuscador {
	//BuscadorService buscadorService; MAL!!!,hay que crear un objeto nuevo de BuscadorService.
	//No es una inyeccion!!
	BuscadorService buscadorService=new BuscadorService();
	@GET
	@Path("/buscar/{tematica}")  //http://localhost:8080/03_prototipo_bucador/buscador/buscar/libros
	@Produces(MediaType.APPLICATION_JSON)//que formato va a aparecer 
	public List<Resultado> buscar(@PathParam(value = "tematica") String tematica) {
		
		return buscadorService.buscar(tematica);
	}
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)//para informarle qué formato viene del cuerpo de la llamada
	public void alta(Resultado resultado) {
		buscadorService.alta(resultado);
	}
	
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> eliminar(@FormParam ("enlace") String enlace) {
		return buscadorService.eliminar(enlace);
	}
	/*     {"enlace": "http://www.mislibros.es/",
        "tematica": "libros",
        "descripcion": "Libros y aaaaaaaaaaaaaaaaaaaaaas"}
            {
        "enlace": "http://www.tech.com/",
        "tematica": "libros",
        "descripcion": "Libros técnicos"
    }
        */
	/*Servicio REST CRUD de cursos

	Desarrollar un servicio REST que permita altas, bajas, modificaciones y busquedas de cursos en una lista
	Un curso se caracteriza por: nombre, area, duracion y precio.

	Los recursos expuestos serán:

	-Alta de curso: se dará de alta un nuevo curso a partir del objeto JSON enviado desde el cliente
	-Baja de curso: se eliminará el curso cuyo nombre se envíe en la URL
	-Actualizar curso: se modificarán los datos del curso (precio, duración y área) a partir del JSON enviado desde el cliente
	-Buscar curso: se devolverá un JSON con los datos del curso a partir del nombre enviado en la URL
	-Listado: se devolverá una lista con todos los cursos existentes */
}
