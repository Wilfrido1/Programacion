package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JButton btnModificar;
	private Cliente cliente = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModCliente dialog = new ModCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModCliente(Cliente pCliente) {
		cliente = pCliente;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCedula = new JLabel("C\u00E9dula: ");
			lblCedula.setBounds(42, 11, 46, 14);
			panel.add(lblCedula);
			
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(42, 59, 46, 14);
			panel.add(lblNombre);
			
			JLabel lblTelefono = new JLabel("Telefono: ");
			lblTelefono.setBounds(42, 109, 75, 14);
			panel.add(lblTelefono);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
			lblDireccion.setBounds(42, 165, 59, 14);
			panel.add(lblDireccion);
			
			textCedula = new JTextField();
			textCedula.setBounds(127, 8, 130, 20);
			panel.add(textCedula);
			textCedula.setColumns(10);
			
			textNombre = new JTextField();
			textNombre.setBounds(127, 56, 130, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			textTelefono = new JTextField();
			textTelefono.setBounds(127, 106, 130, 20);
			panel.add(textTelefono);
			textTelefono.setColumns(10);
			
			textDireccion = new JTextField();
			textDireccion.setBounds(127, 162, 227, 20);
			panel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cliente.setCedula(textCedula.getText());
					cliente.setNombre(textNombre.getText());
					cliente.setTelefono(textTelefono.getText());
					cliente.setDir(textDireccion.getText());
					ListCliente.loadClientes();
					dispose();
				}
			});
			buttonPane.add(btnModificar);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadCliente();
	}
	
	private void loadCliente() {
		if(cliente != null) {
			textCedula.setText(cliente.getCedula());
			textNombre.setText(cliente.getNombre());
			textTelefono.setText(cliente.getTelefono());
			textDireccion.setText(cliente.getDir());
		}
	}
}
