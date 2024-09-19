package service;

import java.util.List;

import model.HotelDto;

public interface HotelesService {
		HotelDto buscarHotelPorId(int id);
		
		List<HotelDto> buscarHotelesPorLocalizacion(String localizacion);
		
	

}
