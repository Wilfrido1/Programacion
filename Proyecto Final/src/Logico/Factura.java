package Logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	public static int numeroFactura = 1;
	private ArrayList<Componente> misComponentes;
	private Cliente cliente;
	private ArrayList<Combo> misCombos;
	
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
	
	public ArrayList<Combo> misCombos(){
		return misCombos;
	}


}
