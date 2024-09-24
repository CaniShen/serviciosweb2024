package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import dao.ReservasDao;
import jakarta.annotation.PostConstruct;
import model.HotelDto;
import model.ReservaDto;
import utilidades.Mapeador;

@Service
public class ReservasServiceImpl implements ReservasService {
	ReservasDao reservasDao;
	Mapeador mapeador;
	RestClient restClientHotel;
	RestClient restClientVuelo;

	public ReservasServiceImpl(ReservasDao reservasDao, Mapeador mapeador, RestClient restClientHotel,RestClient restClientVuelo) {
		super();
		this.reservasDao = reservasDao;
		this.mapeador = mapeador;
		this.restClientHotel = restClientHotel;
		this.restClientVuelo = restClientVuelo;
	}

	@Override
	public List<ReservaDto> buscarPorUsuario(String usuario) {
		if (reservasDao.findByUsuario(usuario) != null) {
			return (reservasDao.findByUsuario(usuario)).stream().map(r -> mapeador.reservaEntityToDto(r)).toList();
		}
		return null;
	}

	@Override
	public void altaReserva(ReservaDto reserva) {
		if (buscarHotelPorId(reserva.getHotelDto().getIdHotel()) != null) {
			if(actualizarVuelos(reserva.getVueloDto().getIdVuelo(), reserva.getVueloDto().getPlazas())) {
				double precioTotal= reserva.getHotelDto().getPrecio() + reserva.getVueloDto().getPrecio();
				reserva.setPrecio(precioTotal);
				reservasDao.save(mapeador.reservadDtoToReserva(reserva));
			}

		}

		

	}

	private HotelDto buscarHotelPorId(int idHotel) {
		String url = "/buscar/" + idHotel;
		return restClientHotel.get().uri(uriBuilder -> uriBuilder.path(url)
                .build()).retrieve().body(HotelDto.class);
	}

	private boolean actualizarVuelos(int idVuelo, int plazas) {
		return restClientVuelo.put()
                .uri(uriBuilder -> uriBuilder.path("/actualizarvuelo")
                        .queryParam("idVuelo", idVuelo)
                        .queryParam("plazas", plazas)
                        .build())
                .retrieve()
                .body(Boolean.class);
	}
	
	
	
}
