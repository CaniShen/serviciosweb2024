package utilidades;

import org.springframework.stereotype.Component;

import entities.Hotel;
import model.HotelDto;
@Component
public class Mapeador {
	public HotelDto hotelEntityToDto(Hotel hotel) {
		return new HotelDto(hotel.getNombre(),hotel.getCategoria(),hotel.getPrecio(),hotel.getDisponible(),hotel.getLocalizacion());
	}
	
	public Hotel hotelDtoToEntity(HotelDto hotel) {
		return new Hotel(0,hotel.getNombre(),hotel.getCategoria(),hotel.getPrecio(),hotel.getDisponible(),hotel.getLocalizacion());
	}

}
