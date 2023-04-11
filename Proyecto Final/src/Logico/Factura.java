package Logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	public static int numeroFactura = 1;
	private ArrayList<Componente> misComponentes;
	private Cliente cliente;
	private ArrayList<Combo> misCombos;
	private float precio;
	
	public Factura(String codigo, Cliente cliente) {
		super();
		this.codigo = codigo;
		misComponentes = new ArrayList<>();
		this.cliente = cliente;
		misCombos = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public void calcPrecio() {
		// TODO Auto-generated method stub
		float total = 0;
		
		for (Componente componente : misComponentes) {
			total+= componente.getPrecio();
		}
		
		for (Combo combo : misCombos) {
			total+= combo.getPrecio();
		}
		
		precio = total;
		
	}
	
	


}
