package controller;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
@ApplicationPath("/")//("/servicio")no suele poner nada, lo ponga para quenos entenderlo
//HTTP:LOCALHOST:8080/01_ejemplo_rest/servicio/pruebas/saludar
public class Config extends Application {
	//no hay que sobrescribir ningun método
	

}
