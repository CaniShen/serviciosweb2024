package controller;

import java.util.List;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Curso;
import service.CursosService;

@Path("/info")
public class CursosController {
	CursosService cursosService=new CursosService();
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alta(Curso curso) {
		cursosService.alta(curso);
		
	}
	@DELETE
	@Path("/eliminar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminar(@PathParam("nombre") String nombre) {
		cursosService.eliminar(nombre);
	}
	
	@GET
	@Path("/devolver")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> buscarCurso(){
		return cursosService.devuelveCursos();
	}

}
