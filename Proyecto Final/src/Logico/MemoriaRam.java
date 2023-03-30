package Logico;

public class MemoriaRam extends Componente {
	
	private float cantMemoria;
	private String unidadMedicion;
	private String tipoMemoria;
	
	public MemoriaRam(float precio, String numSerie, String marca, String modelo, float cantMemoria, String unidadMedicion, String tipoMemoria) {
		super(precio, numSerie, marca, modelo);
		// TODO Auto-generated constructor stub
		this.cantMemoria = cantMemoria;
		this.unidadMedicion = unidadMedicion;
		this.tipoMemoria = tipoMemoria;
		
	}

	public float getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(float cantMemoria) {
		this.cantMemoria = cantMemoria;
	}

	public String getUnidadMedicion() {
		return unidadMedicion;
	}

	public void setUnidadMedicion(String unidadMedicion) {
		this.unidadMedicion = unidadMedicion;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
