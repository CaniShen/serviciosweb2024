package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.HotelesDao;
import entities.Hotel;
import model.HotelDto;
import utilidades.Mapeador;
@Service
public class HotelesServiceImpl implements HotelesService {
	HotelesDao hotelesDao;
	Mapeador mapeador;
	
	
	public HotelesServiceImpl(HotelesDao hotelesDao, Mapeador mapeador) {
		super();
		this.hotelesDao = hotelesDao;
		this.mapeador = mapeador;
	}

	@Override
	public HotelDto buscarHotelPorId(int id) {
		Hotel hotelAux= hotelesDao.findById(id);
		if(hotelAux != null) {
			return mapeador.hotelEntityToDto(hotelAux);
		}
		return null;
	}

	@Override
	public List<HotelDto> buscarHotelesPorLocalizacion(String localizacion) {
		return hotelesDao.findByLocalizacion(localizacion).stream()   // List<Hotel>
					.map(h->mapeador.hotelEntityToDto(h))   //
					.toList();
	
	}

}
