package Logico;

public class Microprocesador extends Componente {

	private String tipoConexion;
	private String unidadMedicion;
	private float velocidadProcesamiento;
	
	public Microprocesador(float precio, String numSerie, String marca, String modelo, String tipoConexion, String unidadMedicion, float velocidadProcesamiento) {
		super(precio, numSerie, marca, modelo);
		// TODO Auto-generated constructor stub
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.unidadMedicion = unidadMedicion;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getUnidadMedicion() {
		return unidadMedicion;
	}

	public void setUnidadMedicion(String unidadMedicion) {
		this.unidadMedicion = unidadMedicion;
	}

	public float getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(float velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
	
}
