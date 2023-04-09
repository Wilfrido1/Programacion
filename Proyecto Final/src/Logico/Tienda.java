package Logico;

import java.util.ArrayList;


public class Tienda {

	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Combo> misCombos;
	public static Tienda tienda = null;
	private ArrayList<Combo> combosVendidos;
	private ArrayList<Componente> componentesVendidos;
	private ArrayList<Componente> componentesEnCombo;
	public static int codigo = 1;

	public Tienda() {
		super();
		misFacturas = new ArrayList<>();
		misClientes = new ArrayList<>();
		misComponentes = new ArrayList<>();
		combosVendidos = new ArrayList<>();
		componentesVendidos = new ArrayList<>();
		componentesEnCombo = new ArrayList<>();
	}


	public static Tienda getInstance(){
		if(tienda==null){
			tienda = new Tienda();
		}
		return tienda;
	}


	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}


	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}


	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}


	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}


	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}


	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}


	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}


	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}


	public ArrayList<Combo> getCombosVendidos() {
		return combosVendidos;
	}


	public void setCombosVendidos(ArrayList<Combo> combosVendidos) {
		this.combosVendidos = combosVendidos;
	}
	
	public void addCombo(Combo combo) {
		misCombos.add(combo);
	}

	public ArrayList<Componente> getComponentesEnCombo(){
		return componentesEnCombo;
	}
	
	public void setComponentesEnCombo(ArrayList<Componente> componentesEnCombo) {
		this.componentesEnCombo = componentesEnCombo;
	}

	public ArrayList<Componente> getComponentesVendidos() {
		return componentesVendidos;
	}


	public void setComponentesVendidos(ArrayList<Componente> componentesVendidos) {
		this.componentesVendidos = componentesVendidos;
	}

	public int crearCombo(ArrayList<Componente> componentes, String nombre) {
		// 1: TODOS LOS COMPONENTES SON COMPATIBLES
		// 2: EL PROCESADOR NO ES COMPATIBLE CON LA MOTHERBOARD
		// 3: LA RAM NO ES COMPATIBLE
		// 4: EL DISCO NO ES COMPATIBLE
		// CREO QUE VAMOS A TENER QUE HACERLO DE OTRA FORMA PQ DE ESTA MANERA SOLO SE CREA UN COMBO

		String ram = null;
		ArrayList<String> conexiones = null;
		String tipoConector = null;
		for (Componente componente : componentes) {
			if(componente instanceof TarjetaMadre) {
				ram = ((TarjetaMadre) componente).getTipoMemRam();
				conexiones = ((TarjetaMadre) componente).getListaConexiones();
				tipoConector = ((TarjetaMadre) componente).getTipoConector();
			}
			if(componente instanceof Microprocesador ) {
				if(!tipoConector.equalsIgnoreCase(((Microprocesador) componente).getTipoConexion()));
				{
					return 2;
				}
			}
			if(componente instanceof MemoriaRam) {
				if(!ram.equalsIgnoreCase(((MemoriaRam) componente).getTipoMemoria()));
				{
					return 3;
				}
			}
			if(componente instanceof DiscoDuro) {
				if(!conexiones.contains(((DiscoDuro) componente).getTipoConexion()));
				{
					return 4;
				}
			}
		}
		//Combo combo = new Combo(nombre, componentes);
		//combo.setMisComponentes(componentes);
		return 1;
	}
	
	public void registrarCliente(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public Cliente buscarClientePorCedula(String Cedula) {
		for(Cliente cliente : misClientes) {
			if(cliente.getCedula().equals(Cedula)) {
				return cliente;
			}
		}
		return null;
	}

	public void registrarComponente(Componente componente) {
		misComponentes.add(componente);
		codigo++;
	}
	
	public Componente buscarComponentePorNumSerie(String numSerie){
	  	for(Componente componente: misComponentes){
	  		if(componente.getNumSerie().equals(numSerie)){
	  			return componente;
	  		}
	  	}
	  	return null;
	  }
	 
	
	public void registrarCombo(Combo combo) {
		misCombos.add(combo);
	}
	
	public Combo buscarComboPorNombre(String Nombre) {
		for(Combo combo : misCombos) {
			if(combo.getNombre().equals(Nombre)) {
				return combo;
			}
		}
		return null;
	}
	
	public boolean clienteExiste(String cedula) {
		for (Cliente cliente : misClientes) {
			if(cliente.getCedula().equalsIgnoreCase(cedula)) {
				return true;
			}
		}
		return false;
	}


	public void insertarFactura(Factura factura) {
		// TODO Auto-generated method stub
		misFacturas.add(factura);
		Factura.numeroFactura++;
		
	}
	
	

}

