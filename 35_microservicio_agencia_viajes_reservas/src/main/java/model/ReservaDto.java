package model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDto {
	private int idReserva;
	@JsonProperty(value ="hotel")
	private HotelDto hotelDto;
	@JsonProperty(value = "vuelo")
	private VueloDto vueloDto;
	private double precio;
	private String usuario;
	public ReservaDto(int idReserva, HotelDto hotelDto, VueloDto vueloDto, double precio, String usuario) {
		super();
		this.idReserva = idReserva;
		this.hotelDto = hotelDto;
		this.vueloDto = vueloDto;
		this.precio = precio;
		this.usuario = usuario;
	}
	
	public ReservaDto() {
		super();
	}

	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public HotelDto getHotelDto() {
		return hotelDto;
	}
	public void setHotelDto(HotelDto hotelDto) {
		this.hotelDto = hotelDto;
	}
	public VueloDto getVueloDto() {
		return vueloDto;
	}
	public void setVueloDto(VueloDto vueloDto) {
		this.vueloDto = vueloDto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
