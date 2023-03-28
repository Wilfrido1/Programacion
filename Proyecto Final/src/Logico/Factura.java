package Logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private ArrayList<Componente> misComponentes;
	private Cliente cliente;
	private ArrayList<Combo> misCombos;
	
	public Factura(String codigo, ArrayList<Componente> misComponentes, Cliente cliente, ArrayList<Combo> misCombos) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.cliente = cliente;
		this.misCombos = misCombos;
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
	
	public ArrayList<Combo> misCombos(){
		return misCombos;
	}


}
