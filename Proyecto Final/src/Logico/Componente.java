package Logico;

import java.io.Serializable;

public abstract class Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 252385328749814275L;
	protected float precio;
	protected int cantDisponible;
	protected String numSerie;
	protected String marca;
	protected String modelo;
	public Componente(float precio, String numSerie, String marca, String modelo) {
		super();
		this.precio = precio;
		this.numSerie = numSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.cantDisponible = 0;
	}
	public int getCantDisponible() {
		return cantDisponible;
	}
	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	
	
}

