package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Combo;
import Logico.Componente;
import Logico.DiscoDuro;
import Logico.MemoriaRam;
import Logico.Microprocesador;
import Logico.TarjetaMadre;
import Logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListCombos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textConexion;
	private JTextField textRam;
	private JTextField textTipoConeccionDD;
	private JTextField textCapAlm;
	private JTextField textUmedicionDD;
	private JCheckBox checkBoxIDE;
	private JCheckBox checkBoxSata;
	private JCheckBox checkBoxSata2;
	private JCheckBox checkBoxSata3;
	private JTextField textTipoMemoria;
	private JTextField textCantMemoria;
	private JTextField textUmedicionMR;
	private JTextField textSocket;
	private JTextField textUmedicionMP;
	private JTextField textProcesamiento;
	private JPanel panelTarjetaMadre;
	private JPanel panelDiscoDuro;
	private JPanel panelMemoriaRam;
	private JPanel panelMicroProcesador;
	private JList listComponentesEnCombo;
	private JList listCombos;
	private DefaultListModel<String> modelComboDisp = new DefaultListModel<>();
	private DefaultListModel <String>modelComponenteEnCombo = new DefaultListModel<>();
	private ArrayList<Componente> componentesEnCombo = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCombos dialog = new ListCombos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCombos() {
		setBounds(100, 100, 715, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 679, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 28, 256, 153);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		listCombos = new JList();
		listCombos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nomb = (String)listCombos.getSelectedValue();
				Combo combo = Tienda.getInstance().buscarComboPorNombre(nomb);
				
				//if(combo != null) {
					TarjetaMadre prueba = new TarjetaMadre((float)1500, "Nomb", "1", "2", "3","4");
					componentesEnCombo.add(prueba);
				componentesEnCombo = combo.getMisComponentes();
				for(Componente comp : componentesEnCombo)
				{
					modelComponenteEnCombo.addElement(comp.getNumSerie());
				}
						
				
				/*if (componentesEnCombo.isEmpty()) {
				    textField.setText("Vacio");
				}*/

				
			}
		});
		scrollPane.setViewportView(listCombos);{
			String combo = null;
			for(Combo aux : Tienda.getInstance().getMisCombos()) {
				//combo = aux.getNombre() + " ";
				combo = aux.getNombre();
				modelComboDisp.addElement(combo);
			}
			listCombos.setModel(modelComboDisp);
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(413, 28, 256, 153);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		listComponentesEnCombo = new JList(modelComponenteEnCombo);
		listComponentesEnCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//mostrarEspecificaciones(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(listComponentesEnCombo.getSelectedValue().toString())));
				//int indexCompComb = listComponentesEnCombo.getSelectedIndex();

			//	textRam.setText(nombtuti);
			//	

				
			//	mostrarEspecificaciones(Tienda.getInstance().buscarComponentePorNumSerie(codigoByComponente(nombComp)));

				
				//modelComponenteEnCombo.getElementAt(index)
			}
		});
		scrollPane_1.setViewportView(listComponentesEnCombo);
		{
		}
		
		JLabel lblNombreCombo = new JLabel("Combos Disponibles:");
		lblNombreCombo.setBounds(10, 11, 256, 14);
		panel.add(lblNombreCombo);
		
		JLabel lblComponentesCombo = new JLabel("Componentes Del Combo: ");
		lblComponentesCombo.setBounds(413, 11, 256, 14);
		panel.add(lblComponentesCombo);
		
		panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTarjetaMadre.setBounds(10, 214, 679, 96);
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
		
		textConexion = new JTextField();
		textConexion.setEnabled(false);
		textConexion.setEditable(false);
		textConexion.setColumns(10);
		textConexion.setBounds(10, 35, 153, 20);
		panelTarjetaMadre.add(textConexion);
		
		textRam = new JTextField();
		textRam.setEnabled(false);
		textRam.setEditable(false);
		textRam.setColumns(10);
		textRam.setBounds(239, 35, 153, 20);
		panelTarjetaMadre.add(textRam);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBounds(10, 214, 775, 66);
		contentPanel.add(panelDiscoDuro);
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_3 = new JLabel("Tipo de Conexi\u00F3n :");
		label_3.setBounds(10, 11, 96, 14);
		panelDiscoDuro.add(label_3);
		
		JLabel label_4 = new JLabel("Capacidad de Almacenamiento:");
		label_4.setBounds(239, 11, 153, 14);
		panelDiscoDuro.add(label_4);
		
		JLabel label_5 = new JLabel("Unidad de Medici\u00F3n:");
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
		panelMemoriaRam.setBounds(10, 214, 775, 66);
		contentPanel.add(panelMemoriaRam);
		
		JLabel label_6 = new JLabel("Tipo de Conexi\u00F3n :");
		label_6.setBounds(10, 11, 96, 14);
		panelMemoriaRam.add(label_6);
		
		JLabel label_7 = new JLabel("Capacidad de Almacenamiento:");
		label_7.setBounds(239, 11, 153, 14);
		panelMemoriaRam.add(label_7);
		
		JLabel label_8 = new JLabel("Unidad de Medici\u00F3n:");
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
		
		panelMicroProcesador = new JPanel();
		panelMicroProcesador.setLayout(null);
		panelMicroProcesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMicroProcesador.setBounds(10, 214, 775, 66);
		contentPanel.add(panelMicroProcesador);
		
		JLabel label_9 = new JLabel("Tipo de Conexi\u00F3n :");
		label_9.setBounds(10, 11, 96, 14);
		panelMicroProcesador.add(label_9);
		
		JLabel label_10 = new JLabel("Capacidad de Almacenamiento:");
		label_10.setBounds(239, 11, 153, 14);
		panelMicroProcesador.add(label_10);
		
		JLabel label_11 = new JLabel("Unidad de Medici\u00F3n:");
		label_11.setBounds(496, 11, 109, 14);
		panelMicroProcesador.add(label_11);
		
		textSocket = new JTextField();
		textSocket.setEnabled(false);
		textSocket.setEditable(false);
		textSocket.setColumns(10);
		textSocket.setBounds(10, 35, 153, 20);
		panelMicroProcesador.add(textSocket);
		
		textUmedicionMP = new JTextField();
		textUmedicionMP.setEnabled(false);
		textUmedicionMP.setEditable(false);
		textUmedicionMP.setColumns(10);
		textUmedicionMP.setBounds(239, 35, 153, 20);
		panelMicroProcesador.add(textUmedicionMP);
		
		textProcesamiento = new JTextField();
		textProcesamiento.setEnabled(false);
		textProcesamiento.setEditable(false);
		textProcesamiento.setColumns(10);
		textProcesamiento.setBounds(496, 35, 153, 20);
		panelMicroProcesador.add(textProcesamiento);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
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
			panelMicroProcesador.setVisible(false);
			panelMemoriaRam.setVisible(false);
			String conector = ((TarjetaMadre) componente).getTipoConector();
			String Ram = ((TarjetaMadre) componente).getTipoMemRam();
			textConexion.setText(conector);
			textRam.setText(Ram);
			
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
			panelMicroProcesador.setVisible(false);
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
			panelMicroProcesador.setVisible(true);
			panelMemoriaRam.setVisible(false);
			
			String socket = ((Microprocesador) componente).getTipoConexion();
			String unidad = ((Microprocesador) componente).getUnidadMedicion();
			String velocidad = Float.toString(((Microprocesador)componente).getVelocidadProcesamiento());
			
			textProcesamiento.setText(velocidad);
			textSocket.setText(socket);
			textUmedicionMP.setText(unidad);
		}
		
		if(componente instanceof MemoriaRam) {
			panelTarjetaMadre.setVisible(false);
			panelDiscoDuro.setVisible(false);
			panelMicroProcesador.setVisible(false);
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
