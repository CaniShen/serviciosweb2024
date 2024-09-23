package service;

import java.util.List;

import model.VueloDto;

public interface VuelosService {
	List<VueloDto> buscarVuelosPorPlazasDestino(int plazas, String destino);
	
	boolean actualizarVuelo(int idVuelo,int plazas);
	
	VueloDto buscarPorId(int id);

}
