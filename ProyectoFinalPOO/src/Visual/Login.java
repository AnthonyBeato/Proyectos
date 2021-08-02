package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

import logico.Administrator;
import logico.Store;
import logico.User;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystemNotFoundException;
import java.util.ResourceBundle.Control;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	int posX = 0, posY = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream enterprise;
				FileOutputStream enterprise2;
				ObjectInputStream enterpriseRead;
				ObjectOutputStream enterpriseWrite;
				try {
					enterprise = new FileInputStream("enterprise.dat");
					enterpriseRead = new ObjectInputStream(enterprise);
					Store temp = (Store)enterpriseRead.readObject();
					Store.setStore(temp); //
					enterprise.close(); 
					enterpriseRead.close();
				} catch (FileNotFoundException e) {
					try {
						enterprise2 = new FileOutputStream("enterprise.dat");
						enterpriseWrite = new ObjectOutputStream(enterprise2);
						Administrator aux = new Administrator(""+Administrator.counter, "Admin", "Admin", "Administrator", 1); 
						System.out.println("Se creo el admin");
						//User aux = new User(User.counter,"Admin","Admin","Administrador");;
						Store.getInstance().addUser(aux);
						enterpriseWrite.writeObject(Store.getInstance());
						enterprise2.close();
						enterpriseWrite.close();
					}catch (FileNotFoundException e1) {
					}catch(IOException e1) {  
						
					}
				} catch (IOException e) {
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
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
	public Login() {
		setTitle("Login");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width - 1000, dim.height - 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(SystemColor.menu));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX = e.getX();
				posY = e.getY();
			}
		});

		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
			}
		});

		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("TechShop");
		lblNewLabel.setForeground(new Color(102, 102, 255));
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 21));
		lblNewLabel.setBounds(20, 18, 107, 36);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("|");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 21));
		label.setBounds(124, 11, 19, 36);
		panel.add(label);

		JLabel lblSistemaDeVentas = new JLabel("Sistema de Ventas");
		lblSistemaDeVentas.setForeground(Color.BLACK);
		lblSistemaDeVentas.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblSistemaDeVentas.setBounds(137, 13, 152, 35);
		panel.add(lblSistemaDeVentas);

		JLabel lblCloseLogin = new JLabel("X");
		lblCloseLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCloseLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblCloseLogin.setForeground(new Color(102, 102, 255));
		lblCloseLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblCloseLogin.setBounds(883, 13, 19, 28);
		panel.add(lblCloseLogin);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtUsuario.setBounds(294, 234, 314, 36);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtPassword.setBounds(294, 321, 314, 36);
		panel.add(txtPassword);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblUsuario.setBounds(294, 193, 63, 36);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblContrasea.setBounds(294, 281, 91, 36);
		panel.add(lblContrasea);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pass = String.valueOf(txtPassword.getPassword());
				if (Store.getInstance().validate(txtUsuario.getText(), pass)) {
					DashboardHome aux = new DashboardHome();
					aux.setVisible(true);
					dispose();
					System.out.println("Se ingreso");
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnNewButton.setBounds(294, 386, 314, 36);
		panel.add(btnNewButton);
		

	}
}
