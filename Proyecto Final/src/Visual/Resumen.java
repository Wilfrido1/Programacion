package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.DiscoDuro;
import Logico.Factura;
import Logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resumen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTarjetaMadre;
	private JTextField txtMicroProcesador;
	private JTextField txtDiscoDuro;
	private JTextField txtIngresosTotales;
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private JTextField txtRam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Resumen dialog = new Resumen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Resumen() {
		setTitle("Resumen de Ventas\r\n");
		setBounds(100, 100, 759, 413);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTM = new JLabel("Tarjeta Madre:");
		lblTM.setBounds(10, 2, 87, 20);
		contentPanel.add(lblTM);
		
		txtTarjetaMadre = new JTextField();
		txtTarjetaMadre.setEditable(false);
		txtTarjetaMadre.setBounds(117, 3, 250, 20);
		contentPanel.add(txtTarjetaMadre);
		txtTarjetaMadre.setColumns(10);

		{
			JLabel lblMP = new JLabel("Micro Procesador:");
			lblMP.setBounds(10, 33, 98, 20);
			contentPanel.add(lblMP);
			
		}
		{
			txtMicroProcesador = new JTextField();
			txtMicroProcesador.setEditable(false);
			txtMicroProcesador.setColumns(10);
			txtMicroProcesador.setBounds(117, 34, 250, 20);
			contentPanel.add(txtMicroProcesador);

		}
		{
			JLabel lblDiscoDuro = new JLabel("Disco Duro:");
			lblDiscoDuro.setBounds(377, 6, 98, 20);
			contentPanel.add(lblDiscoDuro);

		}
		{
			txtDiscoDuro = new JTextField();
			txtDiscoDuro.setEditable(false);
			txtDiscoDuro.setColumns(10);
			txtDiscoDuro.setBounds(485, 3, 250, 20);
			contentPanel.add(txtDiscoDuro);
		}
		{
			JLabel lblingresosTotales = new JLabel("Ingresos Totales:");
			lblingresosTotales.setBounds(377, 40, 98, 14);
			contentPanel.add(lblingresosTotales);
		}
		{
			txtIngresosTotales = new JTextField();
			txtIngresosTotales.setEditable(false);
			txtIngresosTotales.setColumns(10);
			txtIngresosTotales.setBounds(485, 34, 250, 20);
			contentPanel.add(txtIngresosTotales);
			
		}
		
		JLabel lbl = new JLabel("Memoria RAM:");
		lbl.setBounds(10, 65, 87, 20);
		contentPanel.add(lbl);
		
		txtRam = new JTextField();
		txtRam.setText((String) null);
		txtRam.setEditable(false);
		txtRam.setColumns(10);
		txtRam.setBounds(117, 65, 250, 20);
		contentPanel.add(txtRam);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 725, 232);
		contentPanel.add(scrollPane);
		
		String[] headers = {"Código","Cliente","Cant. de Componentes","Cant. de Combos","Total"};

		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		txtIngresosTotales.setText(Float.toString(Tienda.getInstance().ingresosTotales()));
		txtDiscoDuro.setText("Vendidos: " + Integer.toString(Tienda.getInstance().cantVendidosByComponente("DD")) + " |" + " Generado: " + Float.toString(Tienda.getInstance().dineroGeneradoByComponente("DD")));
		txtMicroProcesador.setText("Vendidos: " + Integer.toString(Tienda.getInstance().cantVendidosByComponente("MP")) + " |" + " Generado: " + Float.toString(Tienda.getInstance().dineroGeneradoByComponente("MP")));
		txtTarjetaMadre.setText("Vendidos: " + Integer.toString(Tienda.getInstance().cantVendidosByComponente("TM")) + " |" + " Generado: " + Float.toString(Tienda.getInstance().dineroGeneradoByComponente("TM")));
		txtRam.setText("Vendidos: " + Integer.toString(Tienda.getInstance().cantVendidosByComponente("MR")) + " |" + " Generado: " + Float.toString(Tienda.getInstance().dineroGeneradoByComponente("MR")));
		loadFactura();
	}
	
	private void loadFactura() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
			for (Factura aux: Tienda.getInstance().getMisFacturas()){
				rows[0] = aux.getCodigo();
				rows[1] = aux.getCliente().getNombre() + " (" + aux.getCliente().getCedula() +")"  ;
				rows[2] = aux.getMisComponentes().size();
				rows[3] = aux.getMisCombos().size();
				rows[4] = aux.getPrecio();
				model.addRow(rows);
			}
		}
}
