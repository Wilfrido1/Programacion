package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;


import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Factura;
import Logico.MemoriaRam;
import Logico.Microprocesador;
import Logico.TarjetaMadre;
import Logico.Tienda;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;

public class PedirComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textcodigo;
	private JSpinner spnPrecio;
	private JSpinner spnCantidad;
	private JRadioButton rdbDiscoDuro;
	private JRadioButton rdbMemoriaRam;
	private JRadioButton rdbMicroprocesador;
	private JPanel pnlMicroprocesador;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JPanel panel_1;
	private JLabel lblCdigo;
	private JLabel lblPrecioBase;
	private JLabel lblCostoUnitario;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel pnlMemoriaRam;
	private JLabel lblTipoMemoria;
	private JComboBox cbxTipoMemoria;
	private JLabel lblCantMemoria;
	private JLabel label_4;
	private JComboBox cbxUMedicionMR;
	private JPanel pnlDiscoDuro;
	private JLabel lblTipoConexion;
	private JComboBox cbxTipoConexionDD;
	private JLabel lblCapacidadAlmac;
	private JLabel label_2;
	private JComboBox cbxUmedicionDD;
	private JRadioButton rdbTarjetaMadre;
	protected JComponent pnlTarjetaMadre;
	private JComboBox cbxSocket;
	private JComboBox cbxUmedicionMP;
	private JComboBox cbxSocketTM;
	private JComboBox cbxTipoMemoriaTM;
	private JCheckBox chckbxIDE;
	private JCheckBox chckbxSATA;
	private JCheckBox chckbxSATA2;
	private JCheckBox chckbxSATA3;
	private JSpinner spnCantMemoria;
	private JSpinner spnCapAlm;
	private JSpinner spnVelocidadProces;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PedirComponente dialog = new PedirComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PedirComponente() {
		setTitle("Pedido de Componentes\r\n");
		setBounds(100, 100, 806, 421);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel_1 = new JPanel();
			panel_1.setBounds(5, 5, 775, 152);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel_1);
			panel_1.setLayout(null);

			lblCdigo = new JLabel("N\u00FAmero de Serie: ");
			lblCdigo.setBounds(10, 24, 93, 14);
			panel_1.add(lblCdigo);

			textcodigo = new JTextField();
			textcodigo.setEditable(false);
			textcodigo.setBounds(10, 49, 364, 20);
			panel_1.add(textcodigo);
			textcodigo.setColumns(10);

			lblPrecioBase = new JLabel("Precio:\r\n");
			lblPrecioBase.setBounds(10, 82, 72, 14);
			panel_1.add(lblPrecioBase);

			lblCostoUnitario = new JLabel("Cantidad:");
			lblCostoUnitario.setBounds(213, 82, 93, 14);
			panel_1.add(lblCostoUnitario);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPrecio.setBounds(10, 107, 161, 20);
			panel_1.add(spnPrecio);

			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(213, 107, 161, 20);
			panel_1.add(spnCantidad);

			lblMarca = new JLabel("Marca: ");
			lblMarca.setBounds(401, 24, 93, 14);
			panel_1.add(lblMarca);

			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(401, 49, 364, 20);
			panel_1.add(txtMarca);

			lblModelo = new JLabel("Modelo: ");
			lblModelo.setBounds(401, 82, 93, 14);
			panel_1.add(lblModelo);

			txtModelo = new JTextField();
			txtModelo.setColumns(10);
			txtModelo.setBounds(401, 107, 364, 20);
			panel_1.add(txtModelo);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 161, 775, 66);
		contentPanel.add(panel);
		panel.setLayout(null);

		rdbMicroprocesador = new JRadioButton("Micropocesador");
		rdbMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(true);
				rdbTarjetaMadre.setSelected(false);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible(true);
				pnlTarjetaMadre.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				updateCodigo();
			}
		});
		rdbMicroprocesador.setBounds(362, 25, 118, 23);
		panel.add(rdbMicroprocesador);

		rdbMemoriaRam = new JRadioButton("MemoriaRAM");
		rdbMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMemoriaRam.setSelected(true);
				rdbMicroprocesador.setSelected(false);
				rdbTarjetaMadre.setSelected(false);
				rdbDiscoDuro.setSelected(false);
				pnlMemoriaRam.setVisible(true);
				pnlMicroprocesador.setVisible(false);
				pnlTarjetaMadre.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				updateCodigo();
			}
		});
		rdbMemoriaRam.setBounds(132, 25, 109, 23);
		panel.add(rdbMemoriaRam);

		rdbDiscoDuro = new JRadioButton("Disco Duro");
		rdbDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(true);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(false);
				rdbTarjetaMadre.setSelected(false);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlTarjetaMadre.setVisible(false);
				pnlDiscoDuro.setVisible(true);
				updateCodigo();
			}
		});
		rdbDiscoDuro.setBounds(248, 25, 98, 23);
		panel.add(rdbDiscoDuro);

		rdbTarjetaMadre = new JRadioButton("Tarjeta Madre");
		rdbTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDiscoDuro.setSelected(false);
				rdbMemoriaRam.setSelected(false);
				rdbMicroprocesador.setSelected(false);
				rdbTarjetaMadre.setSelected(true);
				pnlMemoriaRam.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlTarjetaMadre.setVisible(true);
				pnlDiscoDuro.setVisible(false);
			}
		});
		rdbTarjetaMadre.setSelected(true);
		rdbTarjetaMadre.setBounds(6, 25, 127, 23);
		panel.add(rdbTarjetaMadre);

		pnlMicroprocesador = new JPanel();
		pnlMicroprocesador.setVisible(false);
		pnlMicroprocesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMicroprocesador.setBounds(5, 234, 775, 66);
		contentPanel.add(pnlMicroprocesador);
		pnlMicroprocesador.setLayout(null);

		JLabel lblSocket = new JLabel("Tipo de Conexi\u00F3n:");
		lblSocket.setBounds(10, 11, 96, 14);
		pnlMicroprocesador.add(lblSocket);

		cbxSocket = new JComboBox();
		cbxSocket.setModel(new DefaultComboBoxModel(new String[] {"LGA", "PGA", "ZIF", "BGA", "DIP"}));
		cbxSocket.setBounds(10, 35, 153, 20);
		pnlMicroprocesador.add(cbxSocket);

		JLabel lblVelocProces = new JLabel("Velocidad de Procesamiento:");
		lblVelocProces.setBounds(239, 11, 142, 14);
		pnlMicroprocesador.add(lblVelocProces);

		JLabel lblUmedicion = new JLabel("Unidad de Medici\u00F3n:");
		lblUmedicion.setBounds(496, 11, 109, 14);
		pnlMicroprocesador.add(lblUmedicion);

		cbxUmedicionMP = new JComboBox();
		cbxUmedicionMP.setModel(new DefaultComboBoxModel(new String[] {"MHz", "GHz"}));
		cbxUmedicionMP.setBounds(496, 35, 153, 20);
		pnlMicroprocesador.add(cbxUmedicionMP);

		spnVelocidadProces = new JSpinner();
		spnVelocidadProces.setModel(new SpinnerNumberModel(new Float(100), new Float(1), null, new Float(100)));
		spnVelocidadProces.setBounds(239, 35, 153, 20);
		pnlMicroprocesador.add(spnVelocidadProces);
		
		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setVisible(false);
		pnlMemoriaRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMemoriaRam.setBounds(5, 234, 775, 66);
		contentPanel.add(pnlMemoriaRam);
		pnlMemoriaRam.setLayout(null);

		lblTipoMemoria = new JLabel("Tipo de Memoria:");
		lblTipoMemoria.setBounds(10, 11, 96, 14);
		pnlMemoriaRam.add(lblTipoMemoria);

		cbxTipoMemoria = new JComboBox();
		cbxTipoMemoria.setBounds(10, 35, 153, 20);
		cbxTipoMemoria.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
		pnlMemoriaRam.add(cbxTipoMemoria);

		lblCantMemoria = new JLabel("Cantidad de Memoria:");
		lblCantMemoria.setBounds(239, 11, 142, 14);
		pnlMemoriaRam.add(lblCantMemoria);

		label_4 = new JLabel("Unidad de Medici\u00F3n:");
		label_4.setBounds(496, 11, 109, 14);
		pnlMemoriaRam.add(label_4);

		cbxUMedicionMR = new JComboBox();
		cbxUMedicionMR.setBounds(496, 35, 153, 20);
		cbxUMedicionMR.setModel(new DefaultComboBoxModel(new String[] {"GB", "MB"}));
		pnlMemoriaRam.add(cbxUMedicionMR);

		spnCantMemoria = new JSpinner();
		spnCantMemoria.setModel(new SpinnerNumberModel(new Float(100), new Float(1), null, new Float(100)));
		spnCantMemoria.setBounds(239, 35, 153, 20);
		pnlMemoriaRam.add(spnCantMemoria);

		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setBounds(5, 234, 775, 66);
		contentPanel.add(pnlDiscoDuro);
		pnlDiscoDuro.setLayout(null);

		lblTipoConexion = new JLabel("Tipo de Conexi\u00F3n :");
		lblTipoConexion.setBounds(10, 11, 96, 14);
		pnlDiscoDuro.add(lblTipoConexion);

		cbxTipoConexionDD = new JComboBox();
		cbxTipoConexionDD.setBounds(10, 35, 153, 20);
		cbxTipoConexionDD.setModel(new DefaultComboBoxModel(new String[] {"IDE", "SATA", "SATA-2", "SATA-3"}));
		pnlDiscoDuro.add(cbxTipoConexionDD);

		lblCapacidadAlmac = new JLabel("Capacidad de Almacenamiento:");
		lblCapacidadAlmac.setBounds(239, 11, 153, 14);
		pnlDiscoDuro.add(lblCapacidadAlmac);

		label_2 = new JLabel("Unidad de Medici\u00F3n:");
		label_2.setBounds(496, 11, 109, 14);
		pnlDiscoDuro.add(label_2);

		cbxUmedicionDD = new JComboBox();
		cbxUmedicionDD.setBounds(496, 35, 153, 20);
		cbxUmedicionDD.setModel(new DefaultComboBoxModel(new String[] {"GB", "TB"}));
		pnlDiscoDuro.add(cbxUmedicionDD);

		spnCapAlm = new JSpinner();
		spnCapAlm.setModel(new SpinnerNumberModel(new Float(100), new Float(100), null, new Float(100)));
		spnCapAlm.setBounds(239, 35, 153, 20);
		pnlDiscoDuro.add(spnCapAlm);

		pnlTarjetaMadre = new JPanel();
		pnlTarjetaMadre.setLayout(null);
		pnlTarjetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTarjetaMadre.setBounds(5, 234, 775, 96); 
		contentPanel.add(pnlTarjetaMadre);

		JLabel lblTipoSocket = new JLabel("Tipo de Socket :");
		lblTipoSocket.setBounds(10, 11, 96, 14);
		pnlTarjetaMadre.add(lblTipoSocket);

		cbxSocketTM = new JComboBox();
		cbxSocketTM.setModel(new DefaultComboBoxModel(new String[] {"LGA", "PGA", "ZIF", "BGA", "DIP"}));
		cbxSocketTM.setBounds(10, 35, 153, 20);
		pnlTarjetaMadre.add(cbxSocketTM);

		JLabel lblTipoDeRam = new JLabel("Tipo de RAM: ");
		lblTipoDeRam.setBounds(239, 11, 153, 14);
		pnlTarjetaMadre.add(lblTipoDeRam);

		JLabel lblConexionesParaDisco = new JLabel("Conexiones para Disco Duro:");
		lblConexionesParaDisco.setBounds(496, 11, 153, 14);
		pnlTarjetaMadre.add(lblConexionesParaDisco);

		cbxTipoMemoriaTM = new JComboBox();
		cbxTipoMemoriaTM.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
		cbxTipoMemoriaTM.setBounds(239, 35, 153, 20);
		pnlTarjetaMadre.add(cbxTipoMemoriaTM);

		chckbxIDE = new JCheckBox("IDE");
		chckbxIDE.setBounds(496, 32, 97, 23);
		pnlTarjetaMadre.add(chckbxIDE);

		chckbxSATA = new JCheckBox("SATA");
		chckbxSATA.setBounds(496, 58, 97, 23);
		pnlTarjetaMadre.add(chckbxSATA);

		chckbxSATA2 = new JCheckBox("SATA-2");
		chckbxSATA2.setBounds(614, 34, 97, 23);
		pnlTarjetaMadre.add(chckbxSATA2);

		chckbxSATA3 = new JCheckBox("SATA-3");
		chckbxSATA3.setBounds(614, 58, 97, 23);
		pnlTarjetaMadre.add(chckbxSATA3);
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				okButton = new JButton("Pedir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS DE MARCA Y MODELO", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						if(rdbTarjetaMadre.isSelected() && !(chckbxIDE.isSelected() || chckbxSATA.isSelected() || chckbxSATA2.isSelected() || chckbxSATA3.isSelected())) {
							JOptionPane.showMessageDialog(null, "SELECCIONE ALMENOS UN TIPO DE PARA EL DISCO DURO", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							Componente aux = null;
							String codigo = textcodigo.getText();
							float precio = Float.valueOf(spnPrecio.getValue().toString());
							int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
							String marca = txtMarca.getText();
							String modelo = txtModelo.getText();
							if(rdbTarjetaMadre.isSelected()){
								String tipoC = 	cbxSocketTM.getSelectedItem().toString();
								String tipoMR = cbxTipoMemoriaTM.getSelectedItem().toString();
								ArrayList<String> tipoDD = new ArrayList<>();
								if(chckbxIDE.isSelected()) {
									tipoDD.add(chckbxIDE.getText());
								}
								if(chckbxSATA.isSelected()) {
									tipoDD.add(chckbxSATA.getText());
								}
								if(chckbxSATA2.isSelected()) {
									tipoDD.add(chckbxSATA2.getText());
								}
								if(chckbxSATA3.isSelected()) {
									tipoDD.add(chckbxSATA3.getText());
								}
								aux = new TarjetaMadre(precio, codigo, marca, modelo, tipoC, tipoMR);
								((TarjetaMadre) aux).setListaConexiones(tipoDD);

							}
							if(rdbMicroprocesador.isSelected()){
								String unidMed = (String) cbxUmedicionMP.getSelectedItem();
								String tipoC = (String) cbxSocket.getSelectedItem();
								Float velocidad = Float.valueOf(spnVelocidadProces.getValue().toString());
								aux = new Microprocesador(precio, codigo, marca, modelo, tipoC, unidMed, velocidad);
							}
							if(rdbMemoriaRam.isSelected()){
								float cantM = Float.valueOf(spnCantMemoria.getValue().toString());
								String unidMed = (String) cbxUMedicionMR.getSelectedItem();
								String tipoMem = (String) cbxTipoMemoria.getSelectedItem();
								aux = new MemoriaRam(precio, codigo, marca, modelo, cantM, unidMed, tipoMem);
							}
							if(rdbDiscoDuro.isSelected()){
								float capAlm = Float.valueOf(spnCapAlm.getValue().toString());
								String unidMed = (String) cbxUmedicionDD.getSelectedItem();
								String tipoC = (String) cbxTipoConexionDD.getSelectedItem();
								aux = new DiscoDuro(precio, codigo, marca, modelo, capAlm, unidMed, tipoC);
							}
							aux.setCantDisponible(cantidad);
							for(int i = 0; i < cantidad; i++) {
								Tienda.getInstance().registrarComponente(aux);
							}
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		updateCodigo();	
	}

	private void updateCodigo() {
		String pre = "";
		if(rdbTarjetaMadre.isSelected()) {
			pre = "TM";
		}
		if(rdbMicroprocesador.isSelected()){
			pre = "MP";
		}
		if(rdbDiscoDuro.isSelected()){
			pre = "DD";	
		}
		if(rdbMemoriaRam.isSelected()){
			pre = "MR";	
		}
		textcodigo.setText(pre+"-"+Tienda.codigo);

	}

	private void clean() {
		txtMarca.setText(null);
		txtModelo.setText(null);
		pnlTarjetaMadre.setVisible(true);
		pnlMicroprocesador.setVisible(false);
		pnlMemoriaRam.setVisible(false);
		pnlDiscoDuro.setVisible(false);
		rdbTarjetaMadre.setSelected(true);
		rdbDiscoDuro.setSelected(false);
		rdbMemoriaRam.setSelected(false);
		rdbMicroprocesador.setSelected(false);
		spnCantidad.setValue(new Integer(1));
		spnCantMemoria.setValue(new Float (100));
		spnCapAlm.setValue(new Float(100));
		spnPrecio.setValue(new Float(1));
		spnVelocidadProces.setValue(new Float(100));
		chckbxIDE.setSelected(false);
		chckbxSATA.setSelected(false);
		chckbxSATA2.setSelected(false);
		chckbxSATA3.setSelected(false);
		updateCodigo();
	}
}
