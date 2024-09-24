package utilidades;

import org.springframework.stereotype.Component;

import entities.Hotel;
import entities.Reserva;
import entities.Vuelo;
import model.HotelDto;
import model.ReservaDto;
import model.VueloDto;

@Component
public class Mapeador {
	public ReservaDto reservaEntityToDto(Reserva reserva) {
		return new ReservaDto(reserva.getIdReserva(),
				hotelEntityToDto(reserva.getHotel()),
				vueloEntityToDto(reserva.getVuelo()),
				reserva.getPrecio(),
				reserva.getUsuario());
	}
	
/*	public ReservaDto reservaToDto(Reserva reserva) {
		return new ReservaDto(reserva.getIdReserva(),reserva.getUsuario(),
				vueloEntityToDto(reserva.getVuelo()),
				hotelEntityToDto(reserva.getHotel()),
				reserva.getPrecio());
	}*/
	
	public Reserva reservadDtoToReserva(ReservaDto reserva) {
		return new Reserva(reserva.getIdReserva(),
				hotelDtoToEntity(reserva.getHotelDto()),
				vueloDtoToEntity(reserva.getVueloDto()),
				reserva.getPrecio(),
				reserva.getUsuario());
	}
	public Vuelo vueloDtoToEntity(VueloDto vuelo) {
		return new Vuelo(vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}

	public VueloDto vueloEntityToDto(Vuelo vuelo) {
		return new VueloDto(vuelo.getIdvuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}
	

	
	public HotelDto hotelEntityToDto(Hotel hotel) {
		return new HotelDto(hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.getDisponible(),
				hotel.getLocalizacion());
	}
	
	public Hotel hotelDtoToEntity(HotelDto hotel) {
		return new Hotel(0,
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.getDisponible(),
				hotel.getLocalizacion());
	}
	
	
	

	


/*	public HotelDto hotelToDto(Hotel hotel) {
		return new HotelDto(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}*/
/*	public Hotel dtoToHotel(HotelDto hotel) {
		return new Hotel(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}*/



}
