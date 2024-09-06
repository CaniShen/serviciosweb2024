package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;
@Service
public class FormacionServiceImpl implements FormacionService {
	@Value("${usuario}")
	String user;
	@Value("${pwd}")
	String pass;
	
	
	/*@Value("${admin,user}")
	String userAdmin;*/
	String url="http://localhost:8000/cursos/";
	RestClient restClient;
	public FormacionServiceImpl(RestClient restClient) {//inyección por constructor
		this.restClient=restClient;
	}
	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient
				.get()
				.uri(url+"recuperartodos")
				.header("Authorization", "Basic "+getBase64(user, pass))
				.retrieve()  //TODO LOS DE ANTES ESTAN HACIENDO CONFIGURACION, HASTA AQUI NO SE HACE LA PETICIÓN
				.body(Formacion[].class)//Formacion[]
		)//Stream<Formacion>
		.filter(f->f.getArea().equals(area))
		.toList();
	
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		restClient
		.post()
		.uri(url+"alta")
		.contentType(MediaType.APPLICATION_JSON)
		.body(formacion)//el body se lo trasformar el JSON
		.retrieve()/// TODO LOS DE ANTES ESTAN HACIENDO CONFIGURACION, HASTA AQUI NO SE HACE LA PETICIÓN
		.toBodilessEntity();
	}
	private String getBase64(String us, String pwd) {
		String cad=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cad.getBytes());
	} 

}
