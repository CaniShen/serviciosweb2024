package service;

import java.util.List;

import model.VueloDto;

public interface VuelosService {
	List<VueloDto> buscarVuelosPorPlazasDestino(int plazas, String destino);
	
	void actualizarVuelo(VueloDto vuelo);
	
	VueloDto buscarPorId(int id);

}
