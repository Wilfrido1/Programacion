package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Tienda;
import Logico.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Dimension dim;


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
				FileInputStream admin;
				FileOutputStream admin2;
				ObjectInputStream adminRead;
				ObjectOutputStream adminWrite;
				try {
					admin = new FileInputStream ("admin.dat");
					adminRead = new ObjectInputStream(admin);
					Tienda temp = (Tienda)adminRead.readObject();
					Tienda.setTienda(temp);
					Tienda.getInstance().inicializarCodigos();
					admin.close();
					adminRead.close();
				} catch (FileNotFoundException e) {
					try {
						admin2 = new  FileOutputStream("admin.dat");
						User aux = new User("Administrador", "adm", "adm");
						Tienda.getInstance().regUser(aux);
						adminWrite = new ObjectOutputStream(admin2);
						adminWrite.writeObject(Tienda.getInstance());
						admin2.close();
						adminWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {


				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Principal() {
		setTitle("Empresa de Componentes de PC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 564);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream queseria2;
				ObjectOutputStream queseriaWrite;
				try {
					queseria2 = new  FileOutputStream("admin.dat");
					queseriaWrite = new ObjectOutputStream(queseria2);
					queseriaWrite.writeObject(Tienda.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		
		
		/*
		 * File file = new File("misClientes.dat"); FileOutputStream f = new
		 * FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(f);
		 * 
		 * oos.writeInt(Tienda.getInstance().getMisClientes().size()); for (Cliente
		 * person : Tienda.getInstance().getMisClientes()) { oos.writeObject(person); }
		 * oos.close();
		 */

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		
		JMenuItem mntmListadoClientes = new JMenuItem("Listado de Clientes");
		mntmListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoCliente listCliente = new ListadoCliente();
				listCliente.setModal(true);
				listCliente.setVisible(true);
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
				ListadoComponente listaComp = new ListadoComponente();
				listaComp.setModal(true);
				listaComp.setVisible(true);
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
				ListCombos listComb = new ListCombos();
				listComb.setModal(true);
				listComb.setVisible(true);
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
				Resumen resumen = new Resumen();
				resumen.setModal(true);
				resumen.setVisible(true);
			}
		});
		mnVentas.add(mntmListadoFacturas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
