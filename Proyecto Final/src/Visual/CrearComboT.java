package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
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

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CrearComboT extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreCombo;
	private JTextField textPrecio;
	private JTextField txtConexion;
	private JTextField txtRam;
	private JTextField textTipoConeccionDD;
	private JTextField textCapAlm;
	private JTextField textUmedicionDD;
	private JTextField textTipoMemoria;
	private JTextField textCantMemoria;
	private JTextField textUmedicionMR;
	private JTextField textSocket;
	private JTextField textUmedicioMP;
	private JTextField textProcesamiento;
	private JCheckBox checkBoxIDE;
	private JCheckBox checkBoxSata;
	private JCheckBox checkBoxSata2;
	private JCheckBox checkBoxSata3;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JButton btnCrearCombo;
	private JPanel panelTarjetaMadre;
	private JPanel panelDiscoDuro;
	private JPanel panelMemoriaRam;
	private JPanel panelMicroprocesador;
	private JList listComponentesDisponibles;
	private ArrayList<Componente> componentesCarrito;
	private DefaultListModel<String> modelCarrito;
	private DefaultListModel <String>modelDisponibles;
	private JList listComponentesCombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearComboT dialog = new CrearComboT();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearComboT() {
		setTitle("Creaci\u00F3n de Combos");
		componentesCarrito = new ArrayList<>();
		modelCarrito = new DefaultListModel<String>();
		modelDisponibles = new DefaultListModel<String>();
		setBounds(100, 100, 709, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 466, 43);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre del combo:");
		lblNombre.setBounds(10, 11, 163, 21);
		panel.add(lblNombre);
		
		textNombreCombo = new JTextField();
		textNombreCombo.setBounds(114, 11, 342, 20);
		panel.add(textNombreCombo);
		textNombreCombo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 65, 466, 210);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 32, 158, 167);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		listComponentesDisponibles = new JList();
		listComponentesDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarEspecificaciones(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(listComponentesDisponibles.getSelectedValue())));
				}
		});
		scrollPane.setViewportView(listComponentesDisponibles);
		{
			String componente = null;
			for (Componente aux : Tienda.getInstance().getMisComponentes()) {
				componente = aux.getNumSerie() + " ";
				modelDisponibles.addElement(componente);
			}
			listComponentesDisponibles.setModel(modelDisponibles);

		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(298, 32, 158, 167);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		listComponentesCombo = new JList();
		scrollPane_1.setViewportView(listComponentesCombo);
		
		JButton btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String componente = (String) listComponentesDisponibles.getSelectedValue();
				if(textNombreCombo.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}//else{


					if(listComponentesDisponibles.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(rootPane, "NING\u00daN COMPONENTE SELECCIONADO" , "ERROR", HEIGHT);
					}
					else {
						int indice = listComponentesDisponibles.getSelectedIndex();
						modelCarrito.addElement(componente); 
						componentesCarrito.add(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(componente)));
						listComponentesCombo.setModel(modelCarrito);
						totalPrecio();

						if(modelDisponibles.getSize() !=0) {
							modelDisponibles.removeElementAt(indice);
						}
						listComponentesDisponibles.setModel(modelDisponibles);
					    activarCombo();
					}
				}
			});
		btnDerecha.setBounds(187, 61, 89, 23);
		panel_1.add(btnDerecha);
		
		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String componente = (String) listComponentesCombo.getSelectedValue();

				if(listComponentesCombo.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(rootPane, "NING\u00daN COMPONENTE SELECCIONADO" , "ERROR", HEIGHT);
				}
				else {
					int indice = listComponentesCombo.getSelectedIndex();
					modelDisponibles.addElement(componente); 
					componentesCarrito.remove(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(componente)));
					listComponentesDisponibles.setModel(modelDisponibles);
					totalPrecio();

					if(modelCarrito.getSize() !=0) {
						modelCarrito.removeElementAt(indice);
					}
					listComponentesCombo.setModel(modelCarrito);
				}
			}
		});
		btnIzquierda.setBounds(187, 115, 89, 23);
		panel_1.add(btnIzquierda);
		
		JLabel lblCompDisp = new JLabel("Componentes Disponibles: ");
		lblCompDisp.setBounds(10, 11, 158, 14);
		panel_1.add(lblCompDisp);
		
		JLabel lblCompoEnCombo = new JLabel("Componentes en Combo: ");
		lblCompoEnCombo.setBounds(298, 11, 158, 14);
		panel_1.add(lblCompoEnCombo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(486, 258, 46, 14);
		contentPanel.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setText("0.0");
		textPrecio.setBounds(530, 255, 159, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTarjetaMadre.setBounds(10, 286, 679, 96);
		contentPanel.add(panelTarjetaMadre);
		
		JLabel label = new JLabel("Tipo de Socket :");
		label.setBounds(10, 11, 96, 14);
		panelTarjetaMadre.add(label);
		
		JLabel label_1 = new JLabel("Tipo de RAM: ");
		label_1.setBounds(239, 11, 153, 14);
		panelTarjetaMadre.add(label_1);
		
		JLabel label_2 = new JLabel("Conexiones para Disco Duro:");
		label_2.setBounds(496, 11, 153, 14);
		panelTarjetaMadre.add(label_2);
		
		checkBoxIDE = new JCheckBox("IDE");
		checkBoxIDE.setEnabled(false);
		checkBoxIDE.setBounds(496, 32, 97, 23);
		panelTarjetaMadre.add(checkBoxIDE);
		
		checkBoxSata = new JCheckBox("SATA");
		checkBoxSata.setEnabled(false);
		checkBoxSata.setBounds(496, 58, 97, 23);
		panelTarjetaMadre.add(checkBoxSata);
		
		checkBoxSata2 = new JCheckBox("SATA-2");
		checkBoxSata2.setEnabled(false);
		checkBoxSata2.setBounds(614, 34, 97, 23);
		panelTarjetaMadre.add(checkBoxSata2);
		
		checkBoxSata3 = new JCheckBox("SATA-3");
		checkBoxSata3.setEnabled(false);
		checkBoxSata3.setBounds(614, 58, 97, 23);
		panelTarjetaMadre.add(checkBoxSata3);
		
		txtConexion = new JTextField();
		txtConexion.setEnabled(false);
		txtConexion.setEditable(false);
		txtConexion.setColumns(10);
		txtConexion.setBounds(10, 35, 153, 20);
		panelTarjetaMadre.add(txtConexion);
		
		txtRam = new JTextField();
		txtRam.setEnabled(false);
		txtRam.setEditable(false);
		txtRam.setColumns(10);
		txtRam.setBounds(239, 35, 153, 20);
		panelTarjetaMadre.add(txtRam);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDiscoDuro.setBounds(20, 286, 775, 66);
		contentPanel.add(panelDiscoDuro);
		
		label_3 = new JLabel("Tipo de Conexi\u00F3n :");
		label_3.setBounds(10, 11, 96, 14);
		panelDiscoDuro.add(label_3);
		
		label_4 = new JLabel("Capacidad de Almacenamiento:");
		label_4.setBounds(239, 11, 153, 14);
		panelDiscoDuro.add(label_4);
		
		label_5 = new JLabel("Unidad de Medici\u00F3n:");
		label_5.setBounds(496, 11, 109, 14);
		panelDiscoDuro.add(label_5);
		
		textTipoConeccionDD = new JTextField();
		textTipoConeccionDD.setEnabled(false);
		textTipoConeccionDD.setEditable(false);
		textTipoConeccionDD.setColumns(10);
		textTipoConeccionDD.setBounds(10, 35, 153, 20);
		panelDiscoDuro.add(textTipoConeccionDD);
		
		textCapAlm = new JTextField();
		textCapAlm.setEnabled(false);
		textCapAlm.setEditable(false);
		textCapAlm.setColumns(10);
		textCapAlm.setBounds(239, 35, 153, 20);
		panelDiscoDuro.add(textCapAlm);
		
		textUmedicionDD = new JTextField();
		textUmedicionDD.setEnabled(false);
		textUmedicionDD.setEditable(false);
		textUmedicionDD.setColumns(10);
		textUmedicionDD.setBounds(496, 35, 153, 20);
		panelDiscoDuro.add(textUmedicionDD);
		
		panelMemoriaRam = new JPanel();
		panelMemoriaRam.setLayout(null);
		panelMemoriaRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMemoriaRam.setBounds(10, 286, 775, 66);
		contentPanel.add(panelMemoriaRam);
		
		label_6 = new JLabel("Tipo de Conexi\u00F3n :");
		label_6.setBounds(10, 11, 96, 14);
		panelMemoriaRam.add(label_6);
		
		label_7 = new JLabel("Capacidad de Almacenamiento:");
		label_7.setBounds(239, 11, 153, 14);
		panelMemoriaRam.add(label_7);
		
		label_8 = new JLabel("Unidad de Medici\u00F3n:");
		label_8.setBounds(496, 11, 109, 14);
		panelMemoriaRam.add(label_8);
		
		textTipoMemoria = new JTextField();
		textTipoMemoria.setEnabled(false);
		textTipoMemoria.setEditable(false);
		textTipoMemoria.setColumns(10);
		textTipoMemoria.setBounds(10, 35, 153, 20);
		panelMemoriaRam.add(textTipoMemoria);
		
		textCantMemoria = new JTextField();
		textCantMemoria.setEnabled(false);
		textCantMemoria.setEditable(false);
		textCantMemoria.setColumns(10);
		textCantMemoria.setBounds(239, 35, 153, 20);
		panelMemoriaRam.add(textCantMemoria);
		
		textUmedicionMR = new JTextField();
		textUmedicionMR.setEnabled(false);
		textUmedicionMR.setEditable(false);
		textUmedicionMR.setColumns(10);
		textUmedicionMR.setBounds(496, 35, 153, 20);
		panelMemoriaRam.add(textUmedicionMR);
		
		panelMicroprocesador = new JPanel();
		panelMicroprocesador.setLayout(null);
		panelMicroprocesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMicroprocesador.setBounds(10, 286, 775, 66);
		contentPanel.add(panelMicroprocesador);
		
		label_9 = new JLabel("Tipo de Conexi\u00F3n :");
		label_9.setBounds(10, 11, 96, 14);
		panelMicroprocesador.add(label_9);
		
		label_10 = new JLabel("Capacidad de Almacenamiento:");
		label_10.setBounds(239, 11, 153, 14);
		panelMicroprocesador.add(label_10);
		
		label_11 = new JLabel("Unidad de Medici\u00F3n:");
		label_11.setBounds(496, 11, 109, 14);
		panelMicroprocesador.add(label_11);
		
		textSocket = new JTextField();
		textSocket.setEnabled(false);
		textSocket.setEditable(false);
		textSocket.setColumns(10);
		textSocket.setBounds(10, 35, 153, 20);
		panelMicroprocesador.add(textSocket);
		
		textUmedicioMP = new JTextField();
		textUmedicioMP.setEnabled(false);
		textUmedicioMP.setEditable(false);
		textUmedicioMP.setColumns(10);
		textUmedicioMP.setBounds(239, 35, 153, 20);
		panelMicroprocesador.add(textUmedicioMP);
		
		textProcesamiento = new JTextField();
		textProcesamiento.setEnabled(false);
		textProcesamiento.setEditable(false);
		textProcesamiento.setColumns(10);
		textProcesamiento.setBounds(496, 35, 153, 20);
		panelMicroprocesador.add(textProcesamiento);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCrearCombo = new JButton("CrearCombo");
				btnCrearCombo.setEnabled(false);
				btnCrearCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(textNombreCombo.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else if(componentesCarrito.isEmpty()) {
							JOptionPane.showMessageDialog(null, "NO HAY COMPONENTES EN EL CARRITO", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
							Tienda.getInstance().getComponentesEnCombo().addAll(componentesCarrito);
							Tienda.getInstance().getMisComponentes().removeAll(componentesCarrito);
							Combo combo = new Combo("Combo-"+(textNombreCombo.getText()),Float.valueOf(textPrecio.getText()));
							combo.getMisComponentes().addAll(componentesCarrito);
							Tienda.getInstance().addCombo(combo);
							componentesCarrito.removeAll(componentesCarrito);
							modelCarrito.removeAllElements();
							listComponentesCombo.setModel(modelCarrito);
							JOptionPane.showMessageDialog(null, "Operación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
					});
				};
				btnCrearCombo.setActionCommand("OK");
				buttonPane.add(btnCrearCombo);
				getRootPane().setDefaultButton(btnCrearCombo);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				//buttonPane.add(cancelButton);
			}
		}
	

	protected void clean() {
		// TODO Auto-generated method stub
		textNombreCombo.setText(null);
}
	
	protected void totalPrecio() {
		float total = 0;
		for(Componente componente: componentesCarrito) {
			total+= componente.getPrecio();
		}
		
		textPrecio.setText(Float.toString(total));
	}
	
	protected void activarCombo() {
		if(textNombreCombo.getText().length() > 0) {
			btnCrearCombo.setEnabled(true);
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
	
	
	protected void mostrarEspecificaciones(Componente componente) {
		
		if(componente instanceof TarjetaMadre) {
			panelTarjetaMadre.setVisible(true);
			panelDiscoDuro.setVisible(false);
			panelMicroprocesador.setVisible(false);
			panelMemoriaRam.setVisible(false);
			String conector = ((TarjetaMadre) componente).getTipoConector();
			String Ram = ((TarjetaMadre) componente).getTipoMemRam();
			txtConexion.setText(conector);
			txtRam.setText(Ram);
			
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
		
		if(componente instanceof DiscoDuro) {
			panelTarjetaMadre.setVisible(false);
			panelDiscoDuro.setVisible(true);
			panelMicroprocesador.setVisible(false);
			panelMemoriaRam.setVisible(false);
			
			String tipoC = ((DiscoDuro) componente).getTipoConexion();
			String capacidad = Float.toString(((DiscoDuro) componente).getCapAlmacenamiento());
			String unidad = ((DiscoDuro) componente).getUnidadMedicion();
			
			textCapAlm.setText(capacidad);
			textTipoConeccionDD.setText(tipoC);
			textUmedicionDD.setText(unidad);
		}
		
		if(componente instanceof Microprocesador) {
			panelTarjetaMadre.setVisible(false);
			panelDiscoDuro.setVisible(false);
			panelMicroprocesador.setVisible(true);
			panelMemoriaRam.setVisible(false);
			
			String socket = ((Microprocesador) componente).getTipoConexion();
			String unidad = ((Microprocesador) componente).getUnidadMedicion();
			String velocidad = Float.toString(((Microprocesador)componente).getVelocidadProcesamiento());
			
			textProcesamiento.setText(velocidad);
			textSocket.setText(socket);
			textUmedicioMP.setText(unidad);
		}
		
		if(componente instanceof MemoriaRam) {
			panelTarjetaMadre.setVisible(false);
			panelDiscoDuro.setVisible(false);
			panelMicroprocesador.setVisible(false);
			panelMemoriaRam.setVisible(true);
			
			String tipoRam = ((MemoriaRam) componente).getTipoMemoria();
			String cantMemoria = Float.toString(((MemoriaRam)componente).getCantMemoria());
			String unidad = ((MemoriaRam) componente).getUnidadMedicion();
			
			textTipoMemoria.setText(tipoRam);
			textUmedicionMR.setText(unidad);
			textCantMemoria.setText(cantMemoria);
		}
		
	}
}
