package Visual;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import Logico.Tienda;
import Logico.User;
 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class Login extends JDialog {
 
        private final JPanel contentPanel = new JPanel();
        private JTextField txtUsuario;
        private JTextField txtContrasena;
 
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        Login frame = new Login();
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
                                                User aux = new User("Administrador", "admin", "admin");
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
         * Create the dialog.
         */
        public Login() {
                setBounds(100, 100, 365, 153);
                setTitle("Iniciar Sesion");
                setLocationRelativeTo(null);
                getContentPane().setLayout(new BorderLayout());
                contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                getContentPane().add(contentPanel, BorderLayout.CENTER);
                contentPanel.setLayout(new BorderLayout(0, 0));
                {
                        JPanel panel = new JPanel();
                        contentPanel.add(panel, BorderLayout.CENTER);
                        panel.setLayout(null);
                       
                        JLabel lblNewLabel = new JLabel("Usuario:");
                        lblNewLabel.setBounds(10, 11, 57, 14);
                        panel.add(lblNewLabel);
                       
                        txtUsuario = new JTextField();
                        txtUsuario.setBounds(93, 8, 236, 20);
                        panel.add(txtUsuario);
                        txtUsuario.setColumns(10);
                       
                        JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
                        lblContrasena.setBounds(10, 46, 73, 14);
                        panel.add(lblContrasena);
                       
                        txtContrasena = new JTextField();
                        txtContrasena.setColumns(10);
                        txtContrasena.setBounds(93, 43, 236, 20);
                        panel.add(txtContrasena);
                }
                {
                        JPanel buttonPane = new JPanel();
                        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
                        getContentPane().add(buttonPane, BorderLayout.SOUTH);
                        {
                                JButton btnLogin = new JButton("Iniciar Sesion");
                                btnLogin.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                if(Tienda.getInstance().confirmarLogin(txtUsuario.getText(),txtContrasena.getText())){
                                                        Principal principal = new Principal();
                                                        dispose();
                                                        principal.setVisible(true);
                                                }
                                                else {
                                                        JOptionPane.showMessageDialog(null,"Usuario o contraseña Incorrecto!", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                        }
                                });
                                btnLogin.setActionCommand("OK");
                                buttonPane.add(btnLogin);
                                getRootPane().setDefaultButton(btnLogin);
                        }
                        {
                                JButton btnCancelar = new JButton("Cancelar");
                                btnCancelar.setActionCommand("Cancel");
                                buttonPane.add(btnCancelar);
                        }
                }
        }
}
 