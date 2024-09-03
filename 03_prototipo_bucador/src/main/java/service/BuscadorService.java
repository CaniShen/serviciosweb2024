package service;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class BuscadorService {
	static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","música","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			)); 
	
	

	public List<Resultado> buscar(String tematica) {
		/*ArrayList<Resultado> aux=new ArrayList<>();
		 * for(Resultado r:resultado) {
		 * 		if(r.getTematica().equals(tematica)) {
		 * 		aux.add(r);
		 * 	 }
		 * }
		 * return aux;*/	
		return resultados.stream().
				filter(f->f.getTematica().equals(tematica))
				.toList();
	}
	public void alta(Resultado resultado) {
		resultados.add(resultado);
	}
	
	
	/*Añadir un nuevo recurso al servicio que permita eliminar un resultado a partir
	de la url recibida como parámetro. El recurso devolverá una lista con todos los
	resultados que queden después de la eliminación */
	public List<Resultado> eliminar(String url) {
		resultados.removeIf(p->p.getUrl().equals(url));
		return resultados;
	
			
	}
}
