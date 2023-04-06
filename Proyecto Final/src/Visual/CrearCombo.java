package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logico.Combo;
import Logico.Componente;
import Logico.Tienda;

public class CrearCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JList ComponentesDisp;
	private JTextField txtPrecio;
	private JList ComponentesCombo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	
	DefaultListModel modelListDispo = new DefaultListModel();
	DefaultListModel modelListCombo = new DefaultListModel();
	
	int index = 0;
	int size = 0;
	float totalCosto = 0;
			

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCombo dialog = new CrearCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCombo() {
		setBounds(100, 100, 516, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 480, 93);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre del combo: ");
		lblNombre.setBounds(10, 11, 121, 14);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(119, 8, 180, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 115, 480, 224);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 26, 176, 194);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		ComponentesDisp = new JList();
		ComponentesDisp.setModel(modelListDispo);
		scrollPane.setViewportView(ComponentesDisp);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(294, 26, 176, 194);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		ComponentesCombo = new JList();
		ComponentesCombo.setModel(modelListCombo);
		scrollPane_1.setViewportView(ComponentesCombo);
		
		btnDerecha = new JButton(">>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = ComponentesDisp.getSelectedIndex();
				
				if(index != -1) {
					totalCosto += Tienda.getInstance().buscarComponentePorNumSerie(String.valueOf(modelListDispo.getElementAt(index))).getPrecio();
					modelListCombo.addElement(Tienda.getInstance().buscarComponentePorNumSerie(String.valueOf(modelListDispo.getElementAt(index))).getNumSerie());
					
					txtPrecio.setText(String.valueOf(totalCosto));
				}
			}
		});
		btnDerecha.setBounds(195, 62, 89, 23);
		panel_1.add(btnDerecha);
		
		btnIzquierda = new JButton("<<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = ComponentesCombo.getSelectedIndex();
				
				if(index != -1) {
					totalCosto = totalCosto - Tienda.getInstance().buscarComponentePorNumSerie(String.valueOf(modelListCombo.getElementAt(index))).getPrecio();
					
					if(modelListCombo.getSize() == 0)
						totalCosto = 0;
					
					size--;
				}
			}
		});
		btnIzquierda.setBounds(195, 120, 89, 23);
		panel_1.add(btnIzquierda);
		
		JLabel lblComponentesDisp = new JLabel("Componentes Disponibles:");
		lblComponentesDisp.setBounds(10, 11, 176, 14);
		panel_1.add(lblComponentesDisp);
		
		JLabel lblComponentesCombo = new JLabel("Componentes en Combo: ");
		lblComponentesCombo.setBounds(294, 11, 176, 14);
		panel_1.add(lblComponentesCombo);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(317, 350, 46, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("000");
		txtPrecio.setBounds(356, 347, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnCrearCombo = new JButton("Crear Combo");
			btnCrearCombo.setEnabled(false);
			btnCrearCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Componente> componenteEnCombo = new ArrayList<>();
					
					for(int i = 0; i < size; i++) {
						componenteEnCombo.add(Tienda.getInstance().buscarComponentePorNumSerie(String.valueOf(modelListCombo.getElementAt(index))));
					}
					
					Combo auxCombo = new Combo(Tienda.getInstance().toString(), componenteEnCombo);
					Tienda.getInstance().addCombo(auxCombo);
					clean();
				}
			});
			buttonPane.add(btnCrearCombo);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void loadComponentes() 
	{
		for(Componente componente : Tienda.getInstance().getMisComponentes())
		{
			modelListDispo.addElement(componente.getNumSerie());
		}
	}
	
	public void clean() {
		size = 0;
		modelListCombo.clear();
	}
}
