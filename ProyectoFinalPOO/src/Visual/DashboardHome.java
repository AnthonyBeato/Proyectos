package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.Administrator;
import logico.Seller;

import logico.Customer;
import logico.RAM;

import logico.Store;
import logico.User;
import javax.swing.JList;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class DashboardHome extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private static JPanel panelMenu;
	private static JPanel panelUsuarios;
	private static JPanel panelComponentes;
	private static JPanel panelClientes;
	private static JPanel panelFacturas;
	private static JPanel panelAdministracion;
	private JLabel MenuOPC;
	private JLabel FacturasOPC;
	private JLabel ClientesOPC;
	private JLabel ComponentesOPC;
	private JLabel AdministracionOPC;
	private JLabel UsuariosOPC;

	private static Object rows[];

	private JList<String> list_almacen;
	private JList<String> list_carrito;
	
	private DefaultListModel<String> listModelAlmacen;
	private DefaultListModel<String> listModelCarrito;
	
	private JTable table_users;
	private JTable table_invoices;
	private JTable table_customers;
	private JTable table_components;

	private static DefaultTableModel model_users;
	private static DefaultTableModel model_invoices;
	private static DefaultTableModel model_customers;
	private static DefaultTableModel model_components;
	private static JButton btnModificarUsuario;
	private static JButton btnEliminarUsuario;
	private JButton btnNewUsuario;
	private User selected_user = null;
	private Customer selected_customer = null;
	private JLabel TiendaOPC;
	private JPanel panelTienda;
	private JLabel labelTituloTienda;
	private JLabel labelLoggedUser;
	private JLabel ContadorComponentes;
	private JLabel ContadorClientes;
	private JLabel ContadorUsuarios;
	private JLabel ContadorFacturas;
	private JButton btnConfirmarPago;
	private JButton btnEliminarCliente;
	private JButton btnModificarCliente;
	private JButton btnNewCliente;
	private JButton btnEliminarComponente;
	private JButton btnModificarComponente;
	private JButton btnNewComponente;
	private JTextField txtBuscadorCliente;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCredito;
	private JButton btnRemover;
	private JButton btnAgregar;
	private JButton btnFacturar;
	private JRadioButton rdbtnCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardHome frame = new DashboardHome();
					frame.setResizable(false);
					frame.setVisible(true);
					panelUsuarios.setVisible(false);
					panelMenu.setVisible(true);
					panelAdministracion.setVisible(false);
					panelClientes.setVisible(false);
					panelComponentes.setVisible(false);
					panelFacturas.setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardHome() {
		setTitle("TechShop | Control");

		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardHome.class.getResource("/Img/logo800x800.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream enterprise2;
				ObjectOutputStream enterpriseWrite;
				// Store.setLoggedUser(null);
				try {
					enterprise2 = new FileOutputStream("enterprise.dat");
					enterpriseWrite = new ObjectOutputStream(enterprise2);
					enterpriseWrite.writeObject(Store.getInstance());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width - 200, dim.height - 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel MenuLateral = new JPanel();
		MenuLateral.setBackground(Color.WHITE);
		MenuLateral.setBounds(0, 0, 248, 841);
		contentPane.add(MenuLateral);
		MenuLateral.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cerrar Sesi\u00F3n");
		lblNewLabel_1.setForeground(new Color(255, 0, 51));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del Sistema?",
						"Confirmaci\u00F3n", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (opc == 0) {
					FileOutputStream enterprise2;
					ObjectOutputStream enterpriseWrite;
					try {
						enterprise2 = new FileOutputStream("enterprise.dat");
						enterpriseWrite = new ObjectOutputStream(enterprise2);
						enterpriseWrite.writeObject(Store.getInstance());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Login aux = new Login();
					aux.setUndecorated(true);
					aux.setVisible(true);
					dispose();
				}

			}
		});
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(46, 771, 154, 27);
		MenuLateral.add(lblNewLabel_1);

		AdministracionOPC = new JLabel("Administraci\u00F3n");
		if (!(Store.getLoggedUser() instanceof Administrator)) {
			AdministracionOPC.setVisible(false);
			AdministracionOPC.setEnabled(false);
		}
		AdministracionOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(true);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
			}
		});
		AdministracionOPC.setForeground(new Color(102, 102, 255));
		AdministracionOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		AdministracionOPC.setHorizontalAlignment(SwingConstants.CENTER);
		AdministracionOPC.setBounds(46, 440, 154, 27);
		MenuLateral.add(AdministracionOPC);

		FacturasOPC = new JLabel("Facturas");
		FacturasOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(true);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		FacturasOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FacturasOPC.setHorizontalAlignment(SwingConstants.CENTER);
		FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		FacturasOPC.setBounds(46, 402, 154, 27);
		MenuLateral.add(FacturasOPC);

		ClientesOPC = new JLabel("Clientes");
		ClientesOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(true);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		ClientesOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ClientesOPC.setHorizontalAlignment(SwingConstants.CENTER);
		ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		ClientesOPC.setBounds(46, 364, 154, 27);
		MenuLateral.add(ClientesOPC);

		ComponentesOPC = new JLabel("Componentes");
		ComponentesOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(true);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		ComponentesOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ComponentesOPC.setHorizontalAlignment(SwingConstants.CENTER);
		ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		ComponentesOPC.setBounds(46, 326, 154, 27);
		MenuLateral.add(ComponentesOPC);

		UsuariosOPC = new JLabel("Usuarios");
		if (!(Store.getLoggedUser() instanceof Administrator)) {
			UsuariosOPC.setVisible(false);
			UsuariosOPC.setEnabled(false);
		}
		UsuariosOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(true);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		UsuariosOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UsuariosOPC.setHorizontalAlignment(SwingConstants.CENTER);
		UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		UsuariosOPC.setBounds(46, 478, 154, 27);
		MenuLateral.add(UsuariosOPC);

		MenuOPC = new JLabel("Men\u00FA");
		MenuOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(true);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(false);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		MenuOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuOPC.setHorizontalAlignment(SwingConstants.CENTER);
		MenuOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		MenuOPC.setBounds(46, 250, 154, 27);
		MenuLateral.add(MenuOPC);

		JLabel lblNewLabel_4 = new JLabel("TechShop");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(102, 102, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(64, 11, 168, 50);
		MenuLateral.add(lblNewLabel_4);

		JLabel IconoLabel = new JLabel("");
		IconoLabel.setBounds(46, 11, 50, 50);

		ImageIcon ico = new ImageIcon(getClass().getResource("/Img/logo800x800.png"));
		ImageIcon img = new ImageIcon(
				ico.getImage().getScaledInstance(IconoLabel.getWidth(), IconoLabel.getHeight(), Image.SCALE_SMOOTH));
		IconoLabel.setIcon(img);

		MenuLateral.add(IconoLabel);

		if((Store.getLoggedUser() instanceof Administrator)) {
			labelLoggedUser = new JLabel(Store.getLoggedUser().getUsername()+ " | Administrador");
		}else {
			labelLoggedUser = new JLabel(Store.getLoggedUser().getUsername()+ " | Vendedor");
		}


		labelLoggedUser.setForeground(new Color(102, 102, 255));
		labelLoggedUser.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoggedUser.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		labelLoggedUser.setBounds(46, 740, 154, 27);
		MenuLateral.add(labelLoggedUser);

		TiendaOPC = new JLabel("Tienda");
		TiendaOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				panelTienda.setVisible(true);

				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				TiendaOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				AdministracionOPC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			}
		});
		TiendaOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TiendaOPC.setHorizontalAlignment(SwingConstants.CENTER);
		TiendaOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		TiendaOPC.setBounds(46, 288, 154, 27);
		MenuLateral.add(TiendaOPC);

		panelMenu = new JPanel();
		panelMenu.setBounds(247, 0, 1457, 841);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(211, 211, 211));
		separator.setBounds(0, 40, 1457, 11);
		panelMenu.add(separator);

		JLabel labelTitulo = new JLabel("MEN\u00DA");
		labelTitulo.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 0, 87, 40);
		panelMenu.add(labelTitulo);

		final JLabel etiquetaReloj = new JLabel("...");
		etiquetaReloj.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaReloj.setBounds(1207, 0, 240, 40);
		panelMenu.add(etiquetaReloj);

		JLabel lblVistaGeneral = new JLabel("Vista General");
		lblVistaGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblVistaGeneral.setBounds(23, 74, 158, 40);
		panelMenu.add(lblVistaGeneral);

		JPanel panelClienteSuperior = new JPanel();
		panelClienteSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelClienteSuperior.setBackground(new Color(102, 102, 255));
		panelClienteSuperior.setBounds(52, 125, 272, 57);
		panelMenu.add(panelClienteSuperior);
		panelClienteSuperior.setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setBounds(10, 11, 252, 35);
		panelClienteSuperior.add(lblClientes);
		lblClientes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));

		JPanel panelClienteDatos = new JPanel();
		panelClienteDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelClienteDatos.setBackground(Color.WHITE);
		panelClienteDatos.setBounds(52, 182, 272, 89);
		panelMenu.add(panelClienteDatos);
		panelClienteDatos.setLayout(null);

		ContadorClientes = new JLabel("" + Store.getInstance().getCustomers().size()); // Contador de clientes atendidos
		ContadorClientes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		ContadorClientes.setBounds(152, 0, 90, 51);
		panelClienteDatos.add(ContadorClientes);

		System.out.println("La cantidad de clientes es de " + Store.getInstance().getCustomers().size());

		JLabel lblNewLabel_3_1 = new JLabel("Atendidos");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(152, 27, 110, 40);
		panelClienteDatos.add(lblNewLabel_3_1);

		// ICONO DE VISTA CLIENTES
		JLabel IconoClientes = new JLabel("");
		IconoClientes.setBounds(67, 11, 50, 50);
		ImageIcon icoClientes = new ImageIcon(getClass().getResource("/Img/cliente.png"));
		ImageIcon imgClientes = new ImageIcon(icoClientes.getImage().getScaledInstance(IconoClientes.getWidth(),
				IconoClientes.getHeight(), Image.SCALE_SMOOTH));
		IconoClientes.setIcon(imgClientes);

		panelClienteDatos.add(IconoClientes);

		JPanel panelComponentesDatos = new JPanel();
		panelComponentesDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelComponentesDatos.setBackground(Color.WHITE);
		panelComponentesDatos.setBounds(406, 182, 272, 89);
		panelMenu.add(panelComponentesDatos);
		panelComponentesDatos.setLayout(null);

		// ICONO DE VISTA COMPONENTES
		JLabel IconoLabelComponentes = new JLabel("");
		IconoLabelComponentes.setBounds(64, 11, 50, 50);
		ImageIcon icoComponentes = new ImageIcon(getClass().getResource("/Img/componente.png"));
		ImageIcon imgComponentes = new ImageIcon(icoComponentes.getImage().getScaledInstance(
				IconoLabelComponentes.getWidth(), IconoLabelComponentes.getHeight(), Image.SCALE_SMOOTH));
		IconoLabelComponentes.setIcon(imgComponentes);

		panelComponentesDatos.add(IconoLabelComponentes);

		JPanel panelComponentesSuperior = new JPanel();
		panelComponentesSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelComponentesSuperior.setBackground(new Color(102, 102, 255));
		panelComponentesSuperior.setBounds(406, 125, 272, 57);
		panelMenu.add(panelComponentesSuperior);
		panelComponentesSuperior.setLayout(null);

		JLabel lblVistaGeneral_1_1 = new JLabel("Componentes");
		lblVistaGeneral_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral_1_1.setForeground(Color.WHITE);
		lblVistaGeneral_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblVistaGeneral_1_1.setBounds(10, 11, 252, 35);
		panelComponentesSuperior.add(lblVistaGeneral_1_1);

		ContadorComponentes = new JLabel("" + Store.getInstance().getComponents().size()); // Contador de componentes
		ContadorComponentes.setBounds(152, 0, 90, 51);
		panelComponentesDatos.add(ContadorComponentes);
		ContadorComponentes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));

		JLabel lblNewLabel_3_1_1 = new JLabel("Disponibles");
		lblNewLabel_3_1_1.setBounds(152, 27, 110, 40);
		panelComponentesDatos.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));

		JPanel panelUsuariosSuperior = new JPanel();
		panelUsuariosSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelUsuariosSuperior.setBackground(new Color(102, 102, 255));
		panelUsuariosSuperior.setBounds(782, 125, 272, 57);
		panelMenu.add(panelUsuariosSuperior);
		panelUsuariosSuperior.setLayout(null);

		JLabel lblVistaGeneral_1_2 = new JLabel("Usuarios");
		lblVistaGeneral_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral_1_2.setForeground(Color.WHITE);
		lblVistaGeneral_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblVistaGeneral_1_2.setBounds(10, 11, 252, 35);
		panelUsuariosSuperior.add(lblVistaGeneral_1_2);

		JPanel panelUsuariosDatos = new JPanel();
		panelUsuariosDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelUsuariosDatos.setBackground(Color.WHITE);
		panelUsuariosDatos.setBounds(782, 182, 272, 89);
		panelMenu.add(panelUsuariosDatos);
		panelUsuariosDatos.setLayout(null);

		ContadorUsuarios = new JLabel("" + Store.getInstance().getUsers().size()); // Contador de usuarios
		ContadorUsuarios.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		ContadorUsuarios.setBounds(152, 0, 90, 51);
		panelUsuariosDatos.add(ContadorUsuarios);

		JLabel lblNewLabel_3_1_2 = new JLabel("Registrados");
		lblNewLabel_3_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_2.setBounds(152, 27, 110, 40);
		panelUsuariosDatos.add(lblNewLabel_3_1_2);

		JLabel IconoLabelUsuarios = new JLabel("");
		IconoLabelUsuarios.setBounds(67, 11, 50, 50);
		ImageIcon icoUsuarios = new ImageIcon(getClass().getResource("/Img/usuario.png"));
		ImageIcon imgUsuarios = new ImageIcon(icoUsuarios.getImage().getScaledInstance(IconoLabelUsuarios.getWidth(),
				IconoLabelUsuarios.getHeight(), Image.SCALE_SMOOTH));
		IconoLabelUsuarios.setIcon(imgUsuarios);

		panelUsuariosDatos.add(IconoLabelUsuarios);

		JPanel panelFacturasSuperior = new JPanel();
		panelFacturasSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFacturasSuperior.setBackground(new Color(102, 102, 255));
		panelFacturasSuperior.setBounds(1136, 125, 272, 57);
		panelMenu.add(panelFacturasSuperior);
		panelFacturasSuperior.setLayout(null);

		JLabel lblVistaGeneral_1_3 = new JLabel("Facturas");
		lblVistaGeneral_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral_1_3.setForeground(Color.WHITE);
		lblVistaGeneral_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblVistaGeneral_1_3.setBounds(10, 11, 252, 35);
		panelFacturasSuperior.add(lblVistaGeneral_1_3);

		JPanel panelFacturaDatos = new JPanel();
		panelFacturaDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFacturaDatos.setBackground(Color.WHITE);
		panelFacturaDatos.setBounds(1136, 182, 272, 89);
		panelMenu.add(panelFacturaDatos);
		panelFacturaDatos.setLayout(null);

		ContadorFacturas = new JLabel("" + Store.getInstance().getInvoices().size()); // Contador de facturas
		ContadorFacturas.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		ContadorFacturas.setBounds(152, 0, 90, 51);
		panelFacturaDatos.add(ContadorFacturas);

		JLabel lblNewLabel_3_1_3 = new JLabel("Generadas");
		lblNewLabel_3_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_3.setBounds(152, 27, 110, 40);
		panelFacturaDatos.add(lblNewLabel_3_1_3);

		JLabel IconoLabelFacturas = new JLabel("");
		IconoLabelFacturas.setBounds(70, 11, 50, 50);
		ImageIcon icoFactura = new ImageIcon(getClass().getResource("/Img/factura.png"));
		ImageIcon imgFactura = new ImageIcon(icoFactura.getImage().getScaledInstance(IconoLabelFacturas.getWidth(),
				IconoLabelFacturas.getHeight(), Image.SCALE_SMOOTH));
		IconoLabelFacturas.setIcon(imgFactura);

		panelFacturaDatos.add(IconoLabelFacturas);

		JPanel grafica1 = new JPanel();
		grafica1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		grafica1.setBackground(Color.WHITE);
		grafica1.setBounds(52, 426, 626, 353);
		panelMenu.add(grafica1);
		grafica1.setLayout(null);

		JPanel grafica2 = new JPanel();
		grafica2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		grafica2.setBackground(Color.WHITE);
		grafica2.setBounds(782, 426, 626, 353);
		panelMenu.add(grafica2);
		grafica2.setLayout(null);
		
		JPanel panelGraficoSuperior1 = new JPanel();
		panelGraficoSuperior1.setLayout(null);
		panelGraficoSuperior1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGraficoSuperior1.setBackground(new Color(102, 102, 255));
		panelGraficoSuperior1.setBounds(52, 366, 626, 63);
		panelMenu.add(panelGraficoSuperior1);
		
		JLabel Grafico1 = new JLabel("Grafico 1");
		Grafico1.setHorizontalAlignment(SwingConstants.CENTER);
		Grafico1.setForeground(Color.WHITE);
		Grafico1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		Grafico1.setBounds(10, 11, 606, 41);
		panelGraficoSuperior1.add(Grafico1);
		
		JPanel panelGraficoSuperior2 = new JPanel();
		panelGraficoSuperior2.setLayout(null);
		panelGraficoSuperior2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGraficoSuperior2.setBackground(new Color(102, 102, 255));
		panelGraficoSuperior2.setBounds(782, 366, 626, 63);
		panelMenu.add(panelGraficoSuperior2);
		
		JLabel Grafico2 = new JLabel("Grafico 2");
		Grafico2.setHorizontalAlignment(SwingConstants.CENTER);
		Grafico2.setForeground(Color.WHITE);
		Grafico2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		Grafico2.setBounds(10, 11, 606, 41);
		panelGraficoSuperior2.add(Grafico2);

		panelUsuarios = new JPanel();
		panelUsuarios.setBounds(247, 0, 1457, 841);
		contentPane.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		{
			JPanel panelTablaUsuarios = new JPanel();
			panelTablaUsuarios.setSize(1410, 700);
			panelTablaUsuarios.setLocation(25, 125);
			panelTablaUsuarios
					.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelUsuarios.add(panelTablaUsuarios, BorderLayout.CENTER);
			panelTablaUsuarios.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panelTablaUsuarios.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = { "Código", "Nombre", "Nombre de usuario", "Contraseña", "Tipo" };
					model_users = new DefaultTableModel();
					model_users.setColumnIdentifiers(headers);
					table_users = new JTable();
					table_users.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = -1;
							index = table_users.getSelectedRow();
							if (index != -1) {
								btnEliminarUsuario.setEnabled(true);
								btnModificarUsuario.setEnabled(true);
								String id = (String) (model_users.getValueAt(index, 0));
								selected_user = Store.getInstance().search_user(id);
							}
						}
					});
					table_users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table_users.setModel(model_users);
					scrollPane.setViewportView(table_users);
				}
			}

		}

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(211, 211, 211));
		separator_1.setBounds(0, 40, 1457, 11);
		panelUsuarios.add(separator_1);

		JLabel labelTituloUsuarios = new JLabel("USUARIOS");														//USUARIOS
		labelTituloUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloUsuarios.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloUsuarios.setBounds(10, 0, 100, 40);
		panelUsuarios.add(labelTituloUsuarios);

		btnNewUsuario = new JButton("Nuevo Usuario");
		btnNewUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistry user_reg = new UserRegistry(null);
				user_reg.setVisible(true);
				// user_reg.setModal(true);
			}
		});
		btnNewUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewUsuario.setForeground(Color.WHITE);
		btnNewUsuario.setBackground(new Color(102, 102, 255));
		btnNewUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewUsuario.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnNewUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewUsuario.setBounds(1300, 70, 120, 28);
		panelUsuarios.add(btnNewUsuario);

		btnModificarUsuario = new JButton("Modificar");
		btnModificarUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarUsuario.setForeground(Color.WHITE);
		btnModificarUsuario.setBackground(new Color(102, 102, 255));
		btnModificarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarUsuario.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModificarUsuario.setBounds(1145, 70, 130, 28);
		panelUsuarios.add(btnModificarUsuario);

		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEliminarUsuario.setForeground(Color.WHITE);
		btnEliminarUsuario.setBackground(new Color(102, 102, 255));
		btnEliminarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarUsuario.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnEliminarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEliminarUsuario.setBounds(995, 70, 125, 28);
		panelUsuarios.add(btnEliminarUsuario);

		panelComponentes = new JPanel();
		panelComponentes.setBounds(247, 0, 1457, 841);
		contentPane.add(panelComponentes);
		panelComponentes.setLayout(null);

		JLabel labelTituloComponentes = new JLabel("COMPONENTES");															//COMPONENTES
		labelTituloComponentes.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloComponentes.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloComponentes.setBounds(10, 0, 150, 40);
		panelComponentes.add(labelTituloComponentes);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(211, 211, 211));
		separator_1_2.setBounds(0, 40, 1457, 11);
		panelComponentes.add(separator_1_2);
		
		JPanel panelTablaComponentes = new JPanel();
		panelTablaComponentes.setBounds(25, 125, 1410, 700);
		panelComponentes.add(panelTablaComponentes);
		panelTablaComponentes.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelTablaComponentes.add(scrollPane, BorderLayout.CENTER);
			{
				String headers[] = { "Código", "Nombre", "Nombre de usuario", "Contraseña", "Tipo" };
				model_components = new DefaultTableModel();
				model_components.setColumnIdentifiers(headers);
				table_components = new JTable();
				table_components.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table_components.getSelectedRow();
						if (index != -1) {
							btnEliminarUsuario.setEnabled(true);
							btnModificarUsuario.setEnabled(true);
							//String id = (String) (model_components.getValueAt(index, 0));
							//selected_user = Store.getInstance().search_user(id);
						}
					}
				});
				table_components.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_components.setModel(model_components);
				scrollPane.setViewportView(table_components);
			}
		}
		
		btnEliminarComponente = new JButton("Eliminar");
		btnEliminarComponente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarComponente.setForeground(Color.WHITE);
		btnEliminarComponente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEliminarComponente.setEnabled(false);
		btnEliminarComponente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnEliminarComponente.setBackground(new Color(102, 102, 255));
		btnEliminarComponente.setAlignmentX(0.5f);
		btnEliminarComponente.setBounds(995, 70, 125, 28);
		panelComponentes.add(btnEliminarComponente);
		
		btnModificarComponente = new JButton("Modificar");
		btnModificarComponente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarComponente.setForeground(Color.WHITE);
		btnModificarComponente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarComponente.setEnabled(false);
		btnModificarComponente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarComponente.setBackground(new Color(102, 102, 255));
		btnModificarComponente.setAlignmentX(0.5f);
		btnModificarComponente.setBounds(1145, 70, 125, 28);
		panelComponentes.add(btnModificarComponente);
		
		btnNewComponente = new JButton("Nuevo Componente");
		btnNewComponente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewComponente.setForeground(Color.WHITE);
		btnNewComponente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewComponente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnNewComponente.setBackground(new Color(102, 102, 255));
		btnNewComponente.setAlignmentX(0.5f);
		btnNewComponente.setBounds(1295, 70, 135, 28);
		panelComponentes.add(btnNewComponente);

		panelClientes = new JPanel();
		panelClientes.setBounds(247, 0, 1457, 841);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		JLabel labelTituloClientes = new JLabel("CLIENTES");										//CLIENTES
		labelTituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloClientes.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloClientes.setBounds(0, 0, 110, 40);
		panelClientes.add(labelTituloClientes);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(new Color(211, 211, 211));
		separator_1_2_1.setBounds(0, 40, 1457, 11);
		panelClientes.add(separator_1_2_1);

		JPanel panelTablaClientes = new JPanel();
		panelTablaClientes.setBounds(25, 125, 1410, 700);
		panelClientes.add(panelTablaClientes);
		panelTablaClientes.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelTablaClientes.add(scrollPane);
			{
				String headers[] = { "Código", "Nombre", "Nombre de usuario", "Contraseña", "Tipo" };
				model_customers = new DefaultTableModel();
				model_customers.setColumnIdentifiers(headers);
				table_customers = new JTable();
				table_customers.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table_customers.getSelectedRow();
						if (index != -1) {
								btnEliminarCliente.setEnabled(true);
								btnModificarCliente.setEnabled(true);
//								String id = (String)(model_invoices.getValueAt(index, 0));
//								selected_user = Store.getInstance().search_user(id);
								String id = (String)(model_customers.getValueAt(index, 0));
								selected_customer = Store.getInstance().search_customer(id);
								System.out.println(selected_customer.getName());
						}
					}
				});
				table_customers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_customers.setModel(model_customers);
				scrollPane.setViewportView(table_customers);
			}
		}
		
		btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente:"+selected_customer.getId(), "Eliminar cliente", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Store.getInstance().deleteCostumer(selected_customer);
					load_customers();
					btnEliminarCliente.setEnabled(false);
					btnModificarCliente.setEnabled(false);
				}
			}
		});
		btnEliminarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEliminarCliente.setEnabled(false);
		btnEliminarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnEliminarCliente.setBackground(new Color(102, 102, 255));
		btnEliminarCliente.setAlignmentX(0.5f);
		btnEliminarCliente.setBounds(995, 70, 125, 28);
		panelClientes.add(btnEliminarCliente);
		
		btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarCliente.setBackground(new Color(102, 102, 255));
		btnModificarCliente.setAlignmentX(0.5f);
		btnModificarCliente.setBounds(1145, 70, 130, 28);
		panelClientes.add(btnModificarCliente);
		
		btnNewCliente = new JButton("Nuevo Cliente");
		btnNewCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegistry customer_reg = new CustomerRegistry(null);
				customer_reg.setVisible(true);
				// user_reg.setModal(true);
			}
		});
		btnNewCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewCliente.setForeground(Color.WHITE);
		btnNewCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnNewCliente.setBackground(new Color(102, 102, 255));
		btnNewCliente.setAlignmentX(0.5f);
		btnNewCliente.setBounds(1300, 70, 130, 28);
		panelClientes.add(btnNewCliente);

		panelFacturas = new JPanel();
		panelFacturas.setBounds(247, 0, 1457, 841);
		contentPane.add(panelFacturas);
		panelFacturas.setLayout(null);

		JLabel labelTituloFacturas = new JLabel("FACTURAS");													//FACTURAS
		labelTituloFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloFacturas.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloFacturas.setBounds(0, 0, 120, 40);
		panelFacturas.add(labelTituloFacturas);

		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setForeground(new Color(211, 211, 211));
		separator_1_2_2.setBounds(0, 40, 1457, 11);
		panelFacturas.add(separator_1_2_2);

		JPanel panelTablaFacturas = new JPanel();
		panelTablaFacturas.setBounds(25, 125, 1410, 700);
		panelFacturas.add(panelTablaFacturas);
		panelTablaFacturas.setLayout(new BorderLayout(0, 0));

		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelTablaFacturas.add(scrollPane);
			{
				String headers[] = { "Código", "Nombre", "Nombre de usuario", "Contraseña", "Tipo" };
				model_invoices = new DefaultTableModel();
				model_invoices.setColumnIdentifiers(headers);
				table_invoices = new JTable();
				table_invoices.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table_invoices.getSelectedRow();
						if (index != -1) {
//								btnEliminarUsuario.setEnabled(true);
//								btnModificarUsuario.setEnabled(true);
//								String id = (String)(model_invoices.getValueAt(index, 0));
//								selected_user = Store.getInstance().search_user(id);
						}
					}
				});
				table_invoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_invoices.setModel(model_invoices);
				scrollPane.setViewportView(table_invoices);
			}
		}

		btnConfirmarPago = new JButton("Confirmar Pago");
		btnConfirmarPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarPago.setForeground(Color.WHITE);
		btnConfirmarPago.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnConfirmarPago.setEnabled(false);
		btnConfirmarPago.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnConfirmarPago.setBackground(new Color(102, 102, 255));
		btnConfirmarPago.setAlignmentX(0.5f);
		btnConfirmarPago.setBounds(1300, 70, 130, 28);
		panelFacturas.add(btnConfirmarPago);

		panelAdministracion = new JPanel();
		panelAdministracion.setBounds(247, 0, 1457, 841);
		contentPane.add(panelAdministracion);
		panelAdministracion.setLayout(null);

		JLabel labelTituloAdministracion = new JLabel("ADMINISTRACION");
		labelTituloAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloAdministracion.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloAdministracion.setBounds(10, 0, 170, 40);
		panelAdministracion.add(labelTituloAdministracion);

		panelTienda = new JPanel();
		panelTienda.setLayout(null);
		panelTienda.setBounds(247, 0, 1457, 841);
		contentPane.add(panelTienda);

		labelTituloTienda = new JLabel("TIENDA");
		labelTituloTienda.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloTienda.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloTienda.setBounds(0, 0, 100, 40);
		panelTienda.add(labelTituloTienda);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(211, 211, 211));
		separator_1_1.setBounds(0, 40, 1457, 11);
		panelTienda.add(separator_1_1);
		
		JLabel labelSearch = new JLabel("Buscar Cliente:");
		labelSearch.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelSearch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearch.setBounds(23, 74, 158, 40);
		panelTienda.add(labelSearch);
		
		txtBuscadorCliente = new JTextField();
		txtBuscadorCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtBuscadorCliente.setBounds(167, 85, 150, 23);
		panelTienda.add(txtBuscadorCliente);
		txtBuscadorCliente.setColumns(10);
		
		JPanel panelFormularioCliente = new JPanel();
		panelFormularioCliente.setBorder(new TitledBorder(null, "Formulario Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFormularioCliente.setBounds(25, 125, 1410, 100);
		panelTienda.add(panelFormularioCliente);
		panelFormularioCliente.setLayout(null);
		{
			JLabel labelCedula = new JLabel("Cedula:");
			labelCedula.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
			labelCedula.setHorizontalAlignment(SwingConstants.CENTER);
			labelCedula.setBounds(8, 30, 158, 40);	
			panelFormularioCliente.add(labelCedula);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
			txtCedula.setBounds(140, 39, 150, 23);
			panelFormularioCliente.add(txtCedula);
			txtCedula.setColumns(10);
		}
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		labelNombre.setBounds(300, 30, 158, 40);
		panelFormularioCliente.add(labelNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(432, 39, 150, 23);
		panelFormularioCliente.add(txtNombre);
		
		JLabel labelEdad = new JLabel("Edad:");
		labelEdad.setHorizontalAlignment(SwingConstants.CENTER);
		labelEdad.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		labelEdad.setBounds(600, 30, 158, 40);
		panelFormularioCliente.add(labelEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(724, 39, 150, 23);
		panelFormularioCliente.add(txtEdad);
		
		JLabel labelCredito = new JLabel("Credito:");
		labelCredito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCredito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		labelCredito.setBounds(900, 30, 158, 40);
		panelFormularioCliente.add(labelCredito);
		
		txtCredito = new JTextField();
		txtCredito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtCredito.setEditable(false);
		txtCredito.setColumns(10);
		txtCredito.setBounds(1016, 39, 150, 23);
		panelFormularioCliente.add(txtCredito);
		
		JButton btnRegistrarCliente = new JButton("Registrar Cliente");
		btnRegistrarCliente.setForeground(Color.WHITE);
		btnRegistrarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnRegistrarCliente.setEnabled(false);
		btnRegistrarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnRegistrarCliente.setBackground(new Color(102, 102, 255));
		btnRegistrarCliente.setAlignmentX(0.5f);
		btnRegistrarCliente.setBounds(1230, 34, 130, 28);
		panelFormularioCliente.add(btnRegistrarCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(25, 350, 550, 400);
		panelTienda.add(scrollPane);

		
		list_almacen = new JList<String>();
		list_almacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = list_almacen.getSelectedIndex();
				if(index != -1) {
					btnAgregar.setEnabled(true);
				}
			}
		});
		list_almacen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModelAlmacen = new DefaultListModel<String>();
		list_almacen.setModel(listModelAlmacen);
		scrollPane.setViewportView(list_almacen);
		
		JLabel lblProductosEnAlmacen = new JLabel("Productos en Almacen");
		lblProductosEnAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosEnAlmacen.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblProductosEnAlmacen.setBounds(25, 315, 165, 40);
		panelTienda.add(lblProductosEnAlmacen);
		
		btnAgregar = new JButton(">>>");
		btnAgregar.setEnabled(false);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnAgregar.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnAgregar.setBackground(new Color(102, 102, 255));
		btnAgregar.setAlignmentX(0.5f);
		btnAgregar.setBounds(650, 500, 120, 28);
		panelTienda.add(btnAgregar);
		
		btnRemover = new JButton("<<<");
		btnRemover.setEnabled(false);
		btnRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnRemover.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnRemover.setBackground(new Color(102, 102, 255));
		btnRemover.setAlignmentX(0.5f);
		btnRemover.setBounds(650, 600, 120, 28);
		panelTienda.add(btnRemover);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(885, 350, 550, 400);
		panelTienda.add(scrollPane_1);
		
		list_carrito = new JList<String>();
		list_carrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = list_carrito.getSelectedIndex();
				if(index != -1) {
					btnRemover.setEnabled(true);
				}
			}
		});
		list_carrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModelCarrito = new DefaultListModel<String>();
		list_carrito.setModel(listModelCarrito);
		scrollPane_1.setViewportView(list_carrito);
		
		JLabel lblProductosEnCarrito = new JLabel("Carrito de compras");
		lblProductosEnCarrito.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosEnCarrito.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblProductosEnCarrito.setBounds(885, 315, 165, 40);
		panelTienda.add(lblProductosEnCarrito);
		
		btnFacturar = new JButton("Facturar");
		btnFacturar.setForeground(Color.WHITE);
		btnFacturar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnFacturar.setEnabled(false);
		btnFacturar.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnFacturar.setBackground(new Color(102, 102, 255));
		btnFacturar.setAlignmentX(0.5f);
		btnFacturar.setBounds(1315, 785, 120, 28);
		panelTienda.add(btnFacturar);
		
		rdbtnCredito = new JRadioButton("Compra a Credito");
		rdbtnCredito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		rdbtnCredito.setBounds(1150, 785, 145, 28);
		panelTienda.add(rdbtnCredito);
		
		
		
		
		
		
		
//		HILO PARA USAR UN RELOJ ACTUALIZADO
		final DateTimeFormatter formateador = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
						etiquetaReloj.setText(formateador.format(LocalDateTime.now()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hilo = new Thread(runnable);
		hilo.start();

//		HILO PARA REFRESCAR CONTADORES

		Runnable runnableContadores = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						ContadorComponentes.setText("" + Store.getInstance().getComponents().size());
						ContadorClientes.setText("" + Store.getInstance().getCustomers().size());
						ContadorFacturas.setText("" + Store.getInstance().getInvoices().size());
						ContadorUsuarios.setText("" + Store.getInstance().getUsers().size());
						etiquetaReloj.setText(formateador.format(LocalDateTime.now()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hiloContadores = new Thread(runnableContadores);
		hiloContadores.start();

		load_users();
		load_customers();
	}

	public static void load_users() {
		model_users.setRowCount(0);
		rows = new Object[model_users.getColumnCount()];
		for (User user : Store.getInstance().getUsers()) {
			rows[0] = user.getId();
			rows[1] = user.getName();
			rows[2] = user.getUsername();
			rows[3] = user.getPassword();
			if (user instanceof Seller) {
				rows[4] = "Vendedor";
			} else if (user instanceof Administrator) {
				rows[4] = "Administrador";
			}

			model_users.addRow(rows);
		}
		btnEliminarUsuario.setEnabled(false);
		btnModificarUsuario.setEnabled(false);
	}
	
	public static void load_customers() {
		model_customers.setRowCount(0);
		rows = new Object[model_customers.getColumnCount()];
		for (Customer customers : Store.getInstance().getCustomers()) {
			rows[0] = customers.getId();
			rows[1] = customers.getName();
			rows[2] = customers.getCredit();
			rows[3] = customers.getAge();
			rows[4] = "Cliente";
			model_customers.addRow(rows);
		}
		
		btnEliminarUsuario.setEnabled(false);
		btnModificarUsuario.setEnabled(false);
	}
}
