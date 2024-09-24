package model;

public class VueloDto {
	private int idVuelo;
	private String company;
	private String fecha;
	private double precio;
	private int plazas;
	private String destino;
	public VueloDto(int idVuelo, String company, String fecha, double precio, int plazas, String destino) {
		super();
		this.idVuelo = idVuelo;
		this.company = company;
		this.fecha = fecha;
		this.precio = precio;
		this.plazas = plazas;
		this.destino = destino;
	}
	public VueloDto() {
		super();
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdvuelo(int idvuelo) {
		this.idVuelo = idvuelo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
}
