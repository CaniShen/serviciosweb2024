package model;

public class Resultado {
	private String enlace;
	private String tematica;
	private String descripcion;
	public Resultado(String enlace, String tematica, String descripcion) {
		super();
		this.enlace = enlace;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	public Resultado() {
		super();
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	


}
