package service;

import java.util.ArrayList;
import java.util.List;


import model.Curso;

/*Servicio REST CRUD de cursos

Desarrollar un servicio REST que permita altas, bajas, modificaciones y busquedas de cursos en una lista
Un curso se caracteriza por: nombre, area, duracion y precio.

Los recursos expuestos serán:

-Alta de curso: se dará de alta un nuevo curso a partir del objeto JSON enviado desde el cliente
-Baja de curso: se eliminará el curso cuyo nombre se envíe en la URL
-Actualizar curso: se modificarán los datos del curso (precio, duración y área) a partir del JSON enviado desde el cliente
-Buscar curso: se devolverá un JSON con los datos del curso a partir del nombre enviado en la URL
-Listado: se devolverá una lista con todos los cursos existentes */

public class CursosService {
	static List<Curso> cursos=new ArrayList<>(List.of(
			new Curso("java","lenguaje de programacion", 150, 200.0),
			new Curso("python","lenguaje de programacion",100, 150),
			new Curso("ingles", "idioma",80,95.8)
			)); 
	
	
	public void alta(Curso curso) {
		cursos.add(curso);
	}
	
	public void eliminar(String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
	
	public void modificarDatos(String nombre, String area, int duracion, double precio ) {
			for(Curso c:cursos) {
						if(c.getNombre().equals(nombre)) {
							c.setArea(area);
							c.setDuracion(duracion);
							c.setPrecio(precio);
							break;// salimos del bucle for, ya que no necesitamos que se recorre más. ya hemos encontrado el curso y modicado.
						}
		}
	}
	
	public List <Curso> buscarCurso(String nombre) {
		return cursos.stream().
				filter(c->c.getNombre().equals(nombre))
				.toList();
				
	}
	
	public List<Curso> devuelveCursos() {
		
		return cursos;
		
	}
	

}
