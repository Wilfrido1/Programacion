package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Cliente;
import logical.Factura;
import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoCilindricoH;
import logical.QuesoEsferico;
import logical.TiendaQueso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
	private ArrayList<Queso> quesosCarrito;
	private DefaultListModel<String> modelCarrito;
	private DefaultListModel <String>modelDisponibles;
	private JButton btnFacturar;

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
		setTitle("Facturacion de Quesos");
		quesosCarrito = new ArrayList<>();
		modelCarrito = new DefaultListModel<String>();
		modelDisponibles = new DefaultListModel<String>();
		setBounds(100, 100, 522, 476);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 122);
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
				if(TiendaQueso.getInstance().clienteExiste(txtCedula.getText())){
					btnBuscar.setEnabled(false);
					Cliente cliente = TiendaQueso.getInstance().buscarClienteByCedula(txtCedula.getText());
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
		panel_1.setBounds(10, 139, 486, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 34, 177, 174);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		listDisponibles = new JList<String>();
		scrollPane.setViewportView(listDisponibles);
		{
			String queso = null;
			for (Queso aux : TiendaQueso.getInstance().getMisQuesos()) {
				queso = aux.getCodigo() + " Volumen: " + Float.toString(aux.Volumen()) + " Precio: " + Float.toString(aux.precioT());
				modelDisponibles.addElement(queso);
			}
			listDisponibles.setModel(modelDisponibles);

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
				String queso = listDisponibles.getSelectedValue();
				if(txtCedula.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {


					if(listDisponibles.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(rootPane, "NING\u00daN QUESO SELECCIONADO" , "ERROR", HEIGHT);
					}
					else {
						int indice = listDisponibles.getSelectedIndex();
						modelCarrito.addElement(queso); 
						quesosCarrito.add(TiendaQueso.getInstance().buscarQuesoByCodigo(codigoByQueso(queso)));
						listCarrito.setModel(modelCarrito);
						totalCarrito();

						if(modelDisponibles.getSize() !=0) {
							modelDisponibles.removeElementAt(indice);
						}
						listDisponibles.setModel(modelDisponibles);
						activarFacturar();
					}
				}
			}
		});
		btnDerecha.setBounds(200, 83, 89, 25);
		panel_1.add(btnDerecha);

		JButton btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queso = listCarrito.getSelectedValue();

				if(listCarrito.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(rootPane, "NING\u00daN QUESO SELECCIONADO" , "ERROR", HEIGHT);
				}
				else {
					int indice = listCarrito.getSelectedIndex();
					modelDisponibles.addElement(queso); 
					quesosCarrito.remove(TiendaQueso.getInstance().buscarQuesoByCodigo(codigoByQueso(queso)));
					listDisponibles.setModel(modelDisponibles);
					totalCarrito();

					if(modelCarrito.getSize() !=0) {
						modelCarrito.removeElementAt(indice);
					}
					listCarrito.setModel(modelCarrito);
				}
			}
		});
		btnIzquierda.setBounds(200, 119, 89, 23);
		panel_1.add(btnIzquierda);

		JLabel lblQuesosDisponibles = new JLabel("Quesos Disponibles");
		lblQuesosDisponibles.setBounds(10, 11, 177, 14);
		panel_1.add(lblQuesosDisponibles);

		JLabel lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setBounds(299, 9, 177, 14);
		panel_1.add(lblCarritoDeCompra);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(311, 369, 46, 14);
		contentPanel.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(354, 366, 130, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);

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
						}else if(quesosCarrito.isEmpty()) {
							JOptionPane.showMessageDialog(null, "NO HAY QUESOS EN EL CARRITO", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
							if(!TiendaQueso.getInstance().clienteExiste(txtCedula.getText())) {
								Cliente cliente = new Cliente(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(), txtTelefono.getText());
								TiendaQueso.getInstance().insertarCliente(cliente);
							}

							TiendaQueso.getInstance().getQuesosVendidos().addAll(quesosCarrito);
							TiendaQueso.getInstance().getMisQuesos().removeAll(quesosCarrito);
							Factura factura = new Factura("Factura-"+Integer.toString(Factura.numeroFactura),TiendaQueso.getInstance().buscarClienteByCedula(txtCedula.getText()));
							factura.getMisQuesos().addAll(quesosCarrito);
							TiendaQueso.getInstance().insertarFactura(factura);
							quesosCarrito.removeAll(quesosCarrito);
							modelCarrito.removeAllElements();
							listCarrito.setModel(modelCarrito);
							JOptionPane.showMessageDialog(null, "Operación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
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

	protected void totalCarrito() {
		float total = 0;
		for (Queso queso : quesosCarrito) {
			total+= queso.precioT();
		}

		txtTotal.setText(Float.toString(total));
	}


	protected String codigoByQueso(String queso) {
		int indice = queso.indexOf(" ");
		String codigo = null;

		if(indice != -1) {
			codigo = queso.substring(0, indice);
		}

		return codigo;
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
		for (Queso queso : quesosCarrito) {
			TiendaQueso.getInstance().getQuesosVendidos().add(queso);
		}
	}
}
