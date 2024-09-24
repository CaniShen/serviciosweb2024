package service;

import java.util.List;

import model.ReservaDto;

public interface ReservasService {
	List<ReservaDto> buscarPorUsuario(String usuario);
	
	void altaReserva(ReservaDto reserva);
}
