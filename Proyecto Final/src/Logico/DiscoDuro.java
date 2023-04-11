package Logico;

public class DiscoDuro extends Componente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 546221944046415431L;
	private float capAlmacenamiento;
	private String unidadMedicion;
	private String tipoConexion;

	public DiscoDuro(float precio, String numSerie, String marca, String modelo, float capAlmacenamiento, String unidadMedicion, String tipoConexion) {
		super(precio, numSerie, marca, modelo);
		// TODO Auto-generated constructor stub
		this.capAlmacenamiento = capAlmacenamiento;
		this.unidadMedicion = unidadMedicion;
		this.tipoConexion = tipoConexion;
		
	}

	public float getCapAlmacenamiento() {
		return capAlmacenamiento;
	}

	public void setCapAlmacenamiento(float capAlmacenamiento) {
		this.capAlmacenamiento = capAlmacenamiento;
	}

	public String getUnidadMedicion() {
		return unidadMedicion;
	}

	public void setUnidadMedicion(String unidadMedicion) {
		this.unidadMedicion = unidadMedicion;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
