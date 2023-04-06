package Logico;

import java.util.ArrayList;

public class Combo {
	
	private String nombre;
	private ArrayList<Componente> misComponentes;
	private float precio;
	
	public Combo(String nombre, ArrayList<Componente>misComponentes) {
		super();
		this.nombre = nombre;
		this.precio = calcularprecio();
		misComponentes = new ArrayList<>();
	}

	private float calcularprecio() {
		// TODO Auto-generated method stub
		float precio = 0;
		for (Componente componente : misComponentes) {
			precio+= componente.precio;
		}
		precio*=0.9;
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public float getPrecio() {
		return precio;
	}

}
