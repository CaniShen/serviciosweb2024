package cliente;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClienteEjemplo {

	public static void main(String[] args) {
		String url="http://localhost:8080/01_ejemplo_rest/pruebas";
		WebTarget wt=ClientBuilder
					.newClient() //Client
					.target(url);//WebTarget
		//llamadas a los recursos
		String mensaje1= wt
		.path("/saludar") //se devuelve un WebTarget 
		.request(MediaType.TEXT_PLAIN)// que nos va a devolver el texto
		.get(String.class);//porque String es el texto del Java
		
		System.out.println(mensaje1);
		
		String mensaje2=wt
				.path("/saludar/profe")//WebTarger
				.request(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		System.out.println(mensaje2);
		
		String mensaje3=wt
				.path("/info")
				.queryParam("name", "pepe")//webtarger
				.queryParam("age", 15)
				.request(MediaType.TEXT_PLAIN)
				.get(String.class);
		System.out.println(mensaje3);
		
		
		
	}

}
