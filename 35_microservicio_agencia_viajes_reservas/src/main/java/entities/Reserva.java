package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	@ManyToOne
	private List<Hotel> hotel;
	@ManyToOne
	private List<Vuelo> vuelo;
	private double precio;
	private String usuario;
	public Reserva(int idReserva, List<Hotel> hotel, List<Vuelo> vuelo, double precio, String usuario) {
		super();
		this.idReserva = idReserva;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.precio = precio;
		this.usuario = usuario;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public List<Hotel> getHotel() {
		return hotel;
	}
	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	public List<Vuelo> getVuelo() {
		return vuelo;
	}
	public void setVuelo(List<Vuelo> vuelo) {
		this.vuelo = vuelo;
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
