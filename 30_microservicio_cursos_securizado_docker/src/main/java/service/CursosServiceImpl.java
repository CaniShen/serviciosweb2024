package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
@Service
public class CursosServiceImpl implements CursosService {
	private static List<Curso> cursos = new ArrayList<>(List.of(
			new Curso("java", "lenguaje de programacion", 150, 200.0),
			new Curso("python", "lenguaje de programacion", 100, 150), 
			new Curso("ingles", "idiomas", 80, 95.8),
			new Curso("Java 21","Programación",100,200),
			new Curso("Inglés","idiomas",200,340),
			new Curso("Francés","idiomas",150,320),
			new Curso("Python","Programación",60,110)
			));

	@Override
	public boolean alta(Curso curso) {
		if (buscarCurso(curso.getNombre())==null) {
			cursos.add(curso);
			return true;
		}
		return false;
	}

	@Override
	public void eliminar(String nombre) {
		cursos.removeIf(c -> c.getNombre().equals(nombre));
	}

	@Override
	public void modificarDatos(Curso curso) {
		for (Curso c : cursos) {
			if (c.getNombre().equals(curso.getNombre())) {
				c.setArea(curso.getArea());
				c.setDuracion(curso.getDuracion());
				c.setPrecio(curso.getPrecio());
				break;// salimos del bucle for, ya que no necesitamos que se recorre más. ya hemos
						// encontrado el curso y modicado.
			}
		}
	}

	@Override
	public Curso buscarCurso(String nombre) {
		return cursos.stream().filter(c -> c.getNombre().equals(nombre)).findFirst().orElse(null);

	}

	@Override
	public List<Curso> devuelveCursos() {

		return cursos;

	}

}
