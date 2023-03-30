package Logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente{
	
	private String tipoConector;
	private String tipoMemRam;
	private ArrayList<String> listaConexiones;
	public TarjetaMadre(float precio, String numSerie, String marca, String modelo, String tipoConector, String tipoMemRam) {
		super(precio, numSerie, marca, modelo);
		// TODO Auto-generated constructor stub
		this.tipoConector = tipoConector;
		this.tipoMemRam = tipoMemRam;
		listaConexiones = new ArrayList<>();
;	}
	public String getTipoConector() {
		return tipoConector;
	}
	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}
	public String getTipoMemRam() {
		return tipoMemRam;
	}
	public void setTipoMemRam(String tipoMemRam) {
		this.tipoMemRam = tipoMemRam;
	}
	public ArrayList<String> getListaConexiones() {
		return listaConexiones;
	}
	public void setListaConexiones(ArrayList<String> listaConexiones) {
		this.listaConexiones = listaConexiones;
	}

}
