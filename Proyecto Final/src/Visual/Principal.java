package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 564);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		
		JMenuItem mntmListadoClientes = new JMenuItem("Listado de Clientes");
		mntmListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnCliente.add(mntmListadoClientes);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmPedirComponente = new JMenuItem("Pedir Componente");
		mntmPedirComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedirComponente pedirC = new PedirComponente();
				pedirC.setModal(true);
				pedirC.setVisible(true);
			}
		});
		mnComponentes.add(mntmPedirComponente);
		
		JMenuItem mntmListadoComponente = new JMenuItem("Listado de componentes");
		mntmListadoComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnComponentes.add(mntmListadoComponente);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenuItem mntmCrearCombo = new JMenuItem("Crear Combo");
		mntmCrearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearComboT crearC = new CrearComboT();
				crearC.setModal(true);
				crearC.setVisible(true);
			}
		});
		mnCombos.add(mntmCrearCombo);
		
		JMenuItem mntmListadoCombos = new JMenuItem("Listado De Combos");
		mntmListadoCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCombos.add(mntmListadoCombos);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar facturar = new Facturar();
				facturar.setModal(true);
				facturar.setVisible(true);
				
			}
		});
		mnVentas.add(mntmFacturar);
		
		JMenuItem mntmListadoFacturas = new JMenuItem("Listado de Facturas");
		mntmListadoFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVentas.add(mntmListadoFacturas);
		
		JMenu mnResumen = new JMenu("Resumen");
		menuBar.add(mnResumen);
		
		JMenuItem mntmVerResumen = new JMenuItem("Resumen de Ventas");
		mntmVerResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnResumen.add(mntmVerResumen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
