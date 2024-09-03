package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import model.Curso;

/*Servicio REST formación

Crear un servicio REST que exponga un recurso que, a partir de un área reacibida en la URL,
devuelva una listado de cursos que pertenezcan a dicha área. */
public class FormacionService {
	String url = "http://localhost:8080/04_servicio_crud_cursos/cursos";
	WebTarget wt = ClientBuilder.newClient().target(url);

	public List<Curso> buscarPorAre(String area) {
		Curso[] todos = wt
				.path("/recuperartodos")
				.request(MediaType.APPLICATION_JSON)
				.get(Curso[].class);

		return Arrays.stream(todos)
				.filter(f -> f.getArea().equals(area))
				.toList();

	}

	public void altaFormacion(Curso curso) {
	String resp=(String)wt
		.path("/alta")
		.request(MediaType.TEXT_PLAIN)// que lo va a devolver
		.post(Entity.entity(curso, MediaType.APPLICATION_JSON))//converte a un Json//Response
		.getEntity();
	}
}
