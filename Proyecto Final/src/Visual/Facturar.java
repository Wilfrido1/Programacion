package Visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import Logico.Cliente;
import Logico.Combo;
import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Factura;
import Logico.MemoriaRam;
import Logico.Microprocesador;
import Logico.TarjetaMadre;
import Logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private JList<String> listDisponibles;
	private JList<String> listCarrito;
	private JScrollPane scrollPane_1;
	private JTextField txtTotal;
	private ArrayList<Componente> componentesCarrito;
	private ArrayList<Combo> combosCarrito;
	private DefaultListModel<String> modelCarrito;
	private DefaultListModel <String>modelDisponibles;
	private DefaultListModel <String>modelCombos;
	private JButton btnFacturar;
	private JPanel pnlMicroprocesador;
	private JPanel pnlMemoriaRam;
	private JLabel lblTipoMemoria;
	private JLabel lblCantMemoria;
	private JLabel label_4;
	private JPanel pnlDiscoDuro;
	private JLabel lblTipoConexion;
	private JLabel lblCapacidadAlmac;
	private JLabel label_2;
	private JCheckBox checkBoxIDE;
	private JCheckBox checkBoxSata;
	private JCheckBox checkBoxSata2;
	private JCheckBox checkBoxSata3;
	private JTextField txtTConexion;
	private JTextField txtTRam;
	private JTextField txtSocket;
	private JPanel pnlTarjetaMadre;
	private JTextField txtUmedicionMP;
	private JTextField txtVProcesamiento;
	private JTextField txtTipoConeccionDD;
	private JTextField txtCapAlm;
	private JTextField txtUmedicionDD;
	private JTextField txtTipoMemoria;
	private JTextField txtCantMemoria;
	private JTextField txtUmedicionMR;
	private JTextField txtMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JComboBox cbxFiltro;
	private JLabel lblComponentesDisponibles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setTitle("Facturacion de Componentes");
		componentesCarrito = new ArrayList<>();
		combosCarrito = new ArrayList<>();
		modelCarrito = new DefaultListModel<String>();
		modelDisponibles = new DefaultListModel<String>();
		modelCombos = new DefaultListModel<String>();
		setBounds(100, 100, 744, 572);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 679, 122);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 11, 46, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(70, 8, 216, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().clienteExiste(txtCedula.getText())){
					btnBuscar.setEnabled(false);
					Cliente cliente = Tienda.getInstance().buscarClientePorCedula(txtCedula.getText());
					txtCedula.setText(cliente.getCedula());
					txtDireccion.setText(cliente.getDir());
					txtNombre.setText(cliente.getNombre());
					txtTelefono.setText(cliente.getTelefono());
				}
				else {
					JOptionPane.showMessageDialog(null, "Cliente no encontrado, porfavor registrese.", "Información", JOptionPane.INFORMATION_MESSAGE);
					txtCedula.setEnabled(false);
					txtCedula.setEditable(false);
					txtDireccion.setEnabled(true);
					txtDireccion.setEditable(true);
					txtNombre.setEnabled(true);
					txtNombre.setEditable(true);
					txtTelefono.setEnabled(true);
					txtTelefono.setEditable(true);
					btnBuscar.setEnabled(false);

				}
			}
		});
		btnBuscar.setBounds(298, 7, 89, 23);
		panel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 52, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setBounds(70, 42, 216, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(298, 45, 61, 14);
		panel.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(361, 42, 115, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 82, 61, 14);
		panel.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(70, 79, 406, 23);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 679, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		listDisponibles = new JList<String>();
		listDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectedEsComponenteOcombo(listDisponibles.getSelectedValue().toString()) == 1) {
					mostrarEspecificaciones(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(listDisponibles.getSelectedValue())));
				}
				else {
					pnlTarjetaMadre.setVisible(false);
				}
			}
		});
		scrollPane.setViewportView(listDisponibles);
		{
			String componente = null;
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				componente = aux.getNumSerie() + " ";
				modelDisponibles.addElement(componente);
			}
			listDisponibles.setModel(modelDisponibles);
			
			String combo = null;
			for (Combo aux : Tienda.getInstance().getMisCombos()) {
				combo = aux.getNombre();
				modelCombos.addElement(combo);
			}

		}

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 34, 177, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		listCarrito = new JList<String>();
		scrollPane_1.setViewportView(listCarrito);

		JButton btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String componente = listDisponibles.getSelectedValue();
				if(txtCedula.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {


					if(listDisponibles.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(rootPane, "NING\u00daN COMPONENTE/COMBO SELECCIONADO" , "ERROR", HEIGHT);
					}
					else if (cbxFiltro.getSelectedIndex() == 0) {
						int indice = listDisponibles.getSelectedIndex();
						modelCarrito.addElement(componente); 
						componentesCarrito.add(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(componente)));
						listCarrito.setModel(modelCarrito);
						totalCarrito();

						if(modelDisponibles.getSize() !=0) {
							modelDisponibles.removeElementAt(indice);
						}
						listDisponibles.setModel(modelDisponibles);
						activarFacturar();
					}else if(cbxFiltro.getSelectedIndex() == 1) {
						
						modelCarrito.addElement(componente); 
						combosCarrito.add(Tienda.getInstance().buscarComboPorNombre(listDisponibles.getSelectedValue().toString()));
						listCarrito.setModel(modelCarrito);
						totalCarrito();
						listDisponibles.setModel(modelCombos);
						activarFacturar();
					}
				}
			}
		});
		btnDerecha.setBounds(191, 108, 105, 25);
		panel_1.add(btnDerecha);

		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(listCarrito.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(rootPane, "NING\u00daN COMPONENTE/COMBO SELECCIONADO" , "ERROR", HEIGHT);
				}
				else if(selectedEsComponenteOcombo(listCarrito.getSelectedValue()) == 1){
					String componente = listCarrito.getSelectedValue();
					int indice = listCarrito.getSelectedIndex();
					modelDisponibles.addElement(componente); 
					componentesCarrito.remove(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(componente)));
					loadDisponibles(0);
					totalCarrito();

					if(modelCarrito.getSize() !=0) {
						modelCarrito.removeElementAt(indice);
					}
					listCarrito.setModel(modelCarrito);
				}else if(selectedEsComponenteOcombo(listCarrito.getSelectedValue()) == 2) {
					String combo = listCarrito.getSelectedValue();
					int indice = listCarrito.getSelectedIndex();
					combosCarrito.remove(Tienda.getInstance().buscarComboPorNombre(combo));
					loadDisponibles(1);
					totalCarrito();

					if(modelCarrito.getSize() !=0) {
						modelCarrito.removeElementAt(indice);
					}
					listCarrito.setModel(modelCarrito);
				}
			}
		});
		btnIzquierda.setBounds(191, 149, 105, 23);
		panel_1.add(btnIzquierda);

		lblComponentesDisponibles = new JLabel("Componentes Disponibles");
		lblComponentesDisponibles.setBounds(10, 11, 177, 14);
		panel_1.add(lblComponentesDisponibles);

		txtTotal = new JTextField();
		txtTotal.setBounds(520, 188, 149, 20);
		panel_1.add(txtTotal);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(486, 191, 46, 14);
		panel_1.add(lblTotal);

		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setBounds(299, 11, 177, 14);
		panel_1.add(lblCarritoDeCompra);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(520, 11, 46, 14);
		panel_1.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setBounds(520, 34, 149, 20);
		panel_1.add(txtMarca);
		txtMarca.setColumns(10);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(520, 88, 46, 14);
		panel_1.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBounds(520, 113, 149, 20);
		panel_1.add(txtModelo);
		
		cbxFiltro = new JComboBox();
		cbxFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDisponibles(cbxFiltro.getSelectedIndex());
			}
		});
		cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Componentes", "Combos"}));
		cbxFiltro.setBounds(191, 68, 105, 20);
		panel_1.add(cbxFiltro);


		pnlMicroprocesador = new JPanel();
		pnlMicroprocesador.setVisible(false);
		pnlMicroprocesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicroprocesador.setBounds(10, 369, 696, 66);
		contentPanel.add(pnlMicroprocesador);
		pnlMicroprocesador.setLayout(null);

		JLabel lblSocket = new JLabel("Tipo de Conexi\u00F3n:");
		lblSocket.setBounds(10, 11, 119, 14);
		pnlMicroprocesador.add(lblSocket);

		JLabel lblVelocProces = new JLabel("Velocidad de Procesamiento:");
		lblVelocProces.setBounds(239, 11, 167, 14);
		pnlMicroprocesador.add(lblVelocProces);

		JLabel lblUmedicion = new JLabel("Unidad de Medici\u00F3n:");
		lblUmedicion.setBounds(496, 11, 130, 14);
		pnlMicroprocesador.add(lblUmedicion);
		
		txtSocket = new JTextField();
		txtSocket.setEditable(false);
		txtSocket.setBounds(10, 35, 153, 20);
		pnlMicroprocesador.add(txtSocket);
		txtSocket.setColumns(10);
		
		txtUmedicionMP = new JTextField();
		txtUmedicionMP.setEditable(false);
		txtUmedicionMP.setBounds(496, 35, 153, 20);
		pnlMicroprocesador.add(txtUmedicionMP);
		txtUmedicionMP.setColumns(10);
		
		txtVProcesamiento = new JTextField();
		txtVProcesamiento.setEditable(false);
		txtVProcesamiento.setBounds(239, 35, 153, 20);
		pnlMicroprocesador.add(txtVProcesamiento);
		txtVProcesamiento.setColumns(10);

		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setVisible(false);
		pnlMemoriaRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMemoriaRam.setBounds(10, 369, 696, 66);
		contentPanel.add(pnlMemoriaRam);
		pnlMemoriaRam.setLayout(null);

		lblTipoMemoria = new JLabel("Tipo de Memoria:");
		lblTipoMemoria.setBounds(10, 11, 128, 14);
		pnlMemoriaRam.add(lblTipoMemoria);

		lblCantMemoria = new JLabel("Cantidad de Memoria:");
		lblCantMemoria.setBounds(239, 11, 153, 14);
		pnlMemoriaRam.add(lblCantMemoria);

		label_4 = new JLabel("Unidad de Medici\u00F3n:");
		label_4.setBounds(496, 11, 128, 14);
		pnlMemoriaRam.add(label_4);
		
		txtTipoMemoria = new JTextField();
		txtTipoMemoria.setEditable(false);
		txtTipoMemoria.setBounds(10, 35, 153, 20);
		pnlMemoriaRam.add(txtTipoMemoria);
		txtTipoMemoria.setColumns(10);
		
		txtCantMemoria = new JTextField();
		txtCantMemoria.setEditable(false);
		txtCantMemoria.setBounds(239, 35, 153, 20);
		pnlMemoriaRam.add(txtCantMemoria);
		txtCantMemoria.setColumns(10);
		
		txtUmedicionMR = new JTextField();
		txtUmedicionMR.setEditable(false);
		txtUmedicionMR.setBounds(496, 35, 153, 20);
		pnlMemoriaRam.add(txtUmedicionMR);
		txtUmedicionMR.setColumns(10);

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(10, 369, 695, 66);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setLayout(null);

		lblTipoConexion = new JLabel("Tipo de Conexi\u00F3n :");
		lblTipoConexion.setBounds(10, 11, 126, 14);
		pnlDiscoDuro.add(lblTipoConexion);

		lblCapacidadAlmac = new JLabel("Capacidad de Almacenamiento:");
		lblCapacidadAlmac.setBounds(239, 11, 170, 14);
		pnlDiscoDuro.add(lblCapacidadAlmac);

		label_2 = new JLabel("Unidad de Medici\u00F3n:");
		label_2.setBounds(496, 11, 140, 14);
		pnlDiscoDuro.add(label_2);
		
		txtTipoConeccionDD = new JTextField();
		txtTipoConeccionDD.setEditable(false);
		txtTipoConeccionDD.setBounds(10, 35, 153, 20);
		pnlDiscoDuro.add(txtTipoConeccionDD);
		txtTipoConeccionDD.setColumns(10);
		
		txtCapAlm = new JTextField();
		txtCapAlm.setEditable(false);
		txtCapAlm.setBounds(239, 35, 153, 20);
		pnlDiscoDuro.add(txtCapAlm);
		txtCapAlm.setColumns(10);
		
		txtUmedicionDD = new JTextField();
		txtUmedicionDD.setEditable(false);
		txtUmedicionDD.setBounds(496, 35, 153, 20);
		pnlDiscoDuro.add(txtUmedicionDD);
		txtUmedicionDD.setColumns(10);

		pnlTarjetaMadre = new JPanel();
		pnlTarjetaMadre.setLayout(null);
		pnlTarjetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTarjetaMadre.setBounds(10, 369, 696, 96);
		contentPanel.add(pnlTarjetaMadre);

		JLabel label = new JLabel("Tipo de Socket :");
		label.setBounds(10, 11, 114, 14);
		pnlTarjetaMadre.add(label);

		JLabel label_1 = new JLabel("Tipo de RAM: ");
		label_1.setBounds(239, 11, 168, 14);
		pnlTarjetaMadre.add(label_1);

		JLabel label_2 = new JLabel("Conexiones para Disco Duro:");
		label_2.setBounds(496, 11, 190, 14);
		pnlTarjetaMadre.add(label_2);

		checkBoxIDE = new JCheckBox("IDE");
		checkBoxIDE.setEnabled(false);
		checkBoxIDE.setBounds(496, 32, 97, 23);
		pnlTarjetaMadre.add(checkBoxIDE);

		checkBoxSata = new JCheckBox("SATA");
		checkBoxSata.setEnabled(false);
		checkBoxSata.setBounds(496, 58, 97, 23);
		pnlTarjetaMadre.add(checkBoxSata);

		checkBoxSata2 = new JCheckBox("SATA-2");
		checkBoxSata2.setEnabled(false);
		checkBoxSata2.setBounds(614, 34, 97, 23);
		pnlTarjetaMadre.add(checkBoxSata2);

		checkBoxSata3 = new JCheckBox("SATA-3");
		checkBoxSata3.setEnabled(false);
		checkBoxSata3.setBounds(614, 58, 97, 23);
		pnlTarjetaMadre.add(checkBoxSata3);
		
		txtTConexion = new JTextField();
		txtTConexion.setEditable(false);
		txtTConexion.setBounds(10, 35, 153, 20);
		pnlTarjetaMadre.add(txtTConexion);
		txtTConexion.setColumns(10);
		
		txtTRam = new JTextField();
		txtTRam.setEditable(false);
		txtTRam.setBounds(239, 35, 153, 20);
		pnlTarjetaMadre.add(txtTRam);
		txtTRam.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFacturar = new JButton("Facturar");
				btnFacturar.setEnabled(false);
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtCedula.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() ) {
							JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else if(componentesCarrito.isEmpty()) {
							JOptionPane.showMessageDialog(null, "NO HAY COMPONENTES/COMBOS EN EL CARRITO", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
							if(!Tienda.getInstance().clienteExiste(txtCedula.getText())) {
								Cliente cliente = new Cliente(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(), txtTelefono.getText());
								Tienda.getInstance().registrarCliente(cliente);
								
							}
							if(combosCarrito.isEmpty()) {
								Tienda.getInstance().getComponentesVendidos().addAll(componentesCarrito);
								Tienda.getInstance().getMisComponentes().removeAll(componentesCarrito);
								Tienda.getInstance().getCombosVendidos().addAll(combosCarrito);
								Factura factura = new Factura("Factura-"+Integer.toString(Factura.numeroFactura),Tienda.getInstance().buscarClientePorCedula(txtCedula.getText()));
								factura.getMisComponentes().addAll(componentesCarrito);
								factura.getMisCombos().addAll(combosCarrito);
								Tienda.getInstance().insertarFactura(factura);
								factura.calcPrecio();
								componentesCarrito.removeAll(componentesCarrito);
								combosCarrito.removeAll(combosCarrito);
								modelCarrito.removeAllElements();
								listCarrito.setModel(modelCarrito);
								JOptionPane.showMessageDialog(null, "Operación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}else {
								//VALIDAR == 0 NO HAY COMPONENTES
								//VALIDAR == 1 HAY COMPONENTES
								int validar = 1;
								for (Combo combo : combosCarrito) {
									for (Componente componente : combo.getMisComponentes()) {
										if(!Tienda.getInstance().getMisComponentes().contains(componente)) {
											JOptionPane.showMessageDialog(null, "NO HAY COMPONENTES DISPONIBLES PARA HACER EL COMBO "+ combo.getNombre(), "ERROR", JOptionPane.ERROR_MESSAGE);
											validar = 0;
										}
									}
								}
								
								if(validar == 1) {
									Tienda.getInstance().getComponentesVendidos().addAll(componentesCarrito);
									Tienda.getInstance().getMisComponentes().removeAll(componentesCarrito);
									Tienda.getInstance().getCombosVendidos().addAll(combosCarrito);
									Factura factura = new Factura("Factura-"+Integer.toString(Factura.numeroFactura),Tienda.getInstance().buscarClientePorCedula(txtCedula.getText()));
									factura.getMisComponentes().addAll(componentesCarrito);
									factura.getMisCombos().addAll(combosCarrito);
									Tienda.getInstance().insertarFactura(factura);
									factura.calcPrecio();
									componentesCarrito.removeAll(componentesCarrito);
									combosCarrito.removeAll(combosCarrito);
									modelCarrito.removeAllElements();
									listCarrito.setModel(modelCarrito);
									JOptionPane.showMessageDialog(null, "Operación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
									clean();
								}
							}

							
						}
					}
				});
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void loadDisponibles(int index) {
		// TODO Auto-generated method stub
		if(index == 0) {
			lblComponentesDisponibles.setText("Componentes Disponibles");
			listDisponibles.removeAll();
			listDisponibles.setModel(modelDisponibles);
		}
		if(index == 1) {
			lblComponentesDisponibles.setText("Combos Disponibles");
			listDisponibles.removeAll();
			listDisponibles.setModel(modelCombos);
		}
		
	}

	protected void totalCarrito() {
		float total = 0;
		for (Componente componente : componentesCarrito) {
			total+= componente.getPrecio();
		}
		
		for (Combo combo : combosCarrito) {
			total+= combo.getPrecio();
		}

		txtTotal.setText(Float.toString(total));
	}

	protected void activarFacturar() {
		if(txtCedula.getText().length() > 0 && txtDireccion.getText().length() > 0 && txtNombre.getText().length() > 0 && txtTelefono.getText().length() > 0 )
			btnFacturar.setEnabled(true);
	}

	protected void clean() {
		// TODO Auto-generated method stub
		txtCedula.setText(null);
		txtDireccion.setText(null);
		txtNombre.setText(null);
		txtTelefono.setText(null);

		txtCedula.setEnabled(true);
		txtCedula.setEditable(true);
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtTelefono.setEnabled(false);
		txtTelefono.setEditable(false);
		txtTotal.setText(null);
		

		btnBuscar.setEnabled(true);

	}

	protected void insertarVendidos() {
		for (Componente componente : componentesCarrito) {
			Tienda.getInstance().getComponentesVendidos().add(componente);
		}
	}
	protected String codigoByComponente(String componente) {
		int indice = componente.indexOf(" ");
		String codigo = null;

		if(indice != -1) {
			codigo = componente.substring(0, indice);
		}

		return codigo;
	}

	private void mostrarEspecificaciones(Componente componente) {
		
		txtMarca.setText(componente.getMarca());
		txtModelo.setText(componente.getModelo());
		
		if(componente instanceof TarjetaMadre) {
			
			pnlTarjetaMadre.setVisible(true);
			pnlDiscoDuro.setVisible(false);
			pnlMicroprocesador.setVisible(false);
			pnlMemoriaRam.setVisible(false);
			String conector = ((TarjetaMadre) componente).getTipoConector();
			String Ram = ((TarjetaMadre) componente).getTipoMemRam();
			txtTConexion.setText(conector);
			txtTRam.setText(Ram);
			if(((TarjetaMadre) componente).getListaConexiones().contains(checkBoxIDE.getText())) {
				checkBoxIDE.setSelected(true);
			}
			if(((TarjetaMadre) componente).getListaConexiones().contains(checkBoxSata.getText())) {
				checkBoxSata.setSelected(true);
			}
			if(((TarjetaMadre) componente).getListaConexiones().contains(checkBoxSata2.getText())) {
				checkBoxSata2.setSelected(true);
			}
			if(((TarjetaMadre) componente).getListaConexiones().contains(checkBoxSata3.getText())) {
				checkBoxSata3.setSelected(true);
			}
		}
		
		if(componente instanceof Microprocesador) {
			pnlTarjetaMadre.setVisible(false);
			pnlDiscoDuro.setVisible(false);
			pnlMicroprocesador.setVisible(true);
			pnlMemoriaRam.setVisible(false);
			
			String socket = ((Microprocesador) componente).getTipoConexion();
			String unidad = ((Microprocesador) componente).getUnidadMedicion();
			String velocidad = Float.toString(((Microprocesador) componente).getVelocidadProcesamiento());
			
			txtVProcesamiento.setText(velocidad);
			txtSocket.setText(socket);
			txtUmedicionMP.setText(unidad);
		}
		
		if(componente instanceof DiscoDuro) {
			pnlTarjetaMadre.setVisible(false);
			pnlDiscoDuro.setVisible(true);
			pnlMicroprocesador.setVisible(false);
			pnlMemoriaRam.setVisible(false);
			
			String tipoC = ((DiscoDuro) componente).getTipoConexion();
			String capacidad = Float.toString(((DiscoDuro) componente).getCapAlmacenamiento());
			String unidad = ((DiscoDuro) componente).getUnidadMedicion();
			
			txtCapAlm.setText(capacidad);
			txtTipoConeccionDD.setText(tipoC);
			txtUmedicionDD.setText(unidad);
		}
		
		if(componente instanceof MemoriaRam) {
			pnlTarjetaMadre.setVisible(false);
			pnlDiscoDuro.setVisible(false);
			pnlMicroprocesador.setVisible(false);
			pnlMemoriaRam.setVisible(true);
			
			String tipoRam = ((MemoriaRam) componente).getTipoMemoria();
			String cantMemoria = Float.toString(((MemoriaRam) componente).getCantMemoria());
			String unidad = ((MemoriaRam) componente).getUnidadMedicion();
			
			txtTipoMemoria.setText(tipoRam);
			txtUmedicionMR.setText(unidad);
			txtCantMemoria.setText(cantMemoria);
			
			
		}
	}
	private int selectedEsComponenteOcombo(String string) {
		// TODO Auto-generated method stub
		//RETORNA 1 SI ES UN COMPONENTE
		// RETORNA 2 SI ES UN CONMBO
		int opc = 1;
		String corte = string.substring(0, 4);
		if(corte.equalsIgnoreCase("Combo")) {
			opc = 2;
		}
		
		return opc;
	}
}
