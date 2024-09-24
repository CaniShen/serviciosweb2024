package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.ReservasDao;
import model.ReservaDto;
import utilidades.Mapeador;
@Service
public class ReservasServiceImpl implements ReservasService {
	ReservasDao reservasDao;
	Mapeador mapeador;
	

	public ReservasServiceImpl(ReservasDao reservasDao, Mapeador mapeador) {
		super();
		this.reservasDao = reservasDao;
		this.mapeador = mapeador;
	}


	@Override
	public List<ReservaDto> buscarPorUsuario(String usuario) {
			if (reservasDao.findByUsuario(usuario)!=null) {
				return (reservasDao.findByUsuario(usuario)).stream()
							.map(r->mapeador.reservaEntityToDto(r))
								.toList();
			}
		return null;
	}


	@Override
	public void altaReserva(ReservaDto reserva)  {
			if	(reservasDao.existsById(reserva.getIdReserva())){
				 System.out.println("La reserva ya existe.");
			}else {
				reservasDao.save(mapeador.reservadDtoToReserva(reserva));
				
			}
	
	}
}
