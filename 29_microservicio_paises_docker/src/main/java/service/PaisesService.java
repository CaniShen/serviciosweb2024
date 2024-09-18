package service;
/*Microservicio paises

Crear un microservicio cliente del servicio público de paises. Este servicio tendrá dos recursos:

-lista de continentes
-lista de paises del continente cuyo nombre se recibe en url

Cada pais tiene los siguientes campos: nombre,continente,capital, población y bandera*/


import java.util.List;

import model.Pais;

public interface PaisesService {
	List<String> continentes();
	
	List<Pais> paisesePorContinente(String continente);
}
