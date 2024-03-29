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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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
import logico.CPU;
import logico.Combo;
import logico.Seller;

import logico.Customer;
import logico.Drive;
import logico.Invoice;
import logico.Motherboard;
import logico.PurchaseOrder;
import logico.RAM;

import logico.Store;
import logico.User;
import javax.swing.JList;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.PieChartDemo1;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.RootPaneContainer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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

	private DefaultListModel<String> listModelAlmacen = new DefaultListModel<String>();
	private DefaultListModel<String> listModelCarrito = new DefaultListModel<String>();

	private JTable table_users;
	private JTable table_invoices;
	private JTable table_ordersPurchase;
	private JTable table_customers;
	private JTable table_components;

	private static DefaultTableModel model_users;
	private static DefaultTableModel model_invoices;
	private static DefaultTableModel model_customers;
	private static DefaultTableModel model_components;
	private static DefaultTableModel model_ordersPurchase;
	private static JButton btnModificarUsuario;
	private static JButton btnEliminarUsuario;
	private JButton btnNewUsuario;
	private User selected_user = null;
	private Invoice selected_invoice = null;
	private logico.Component selected_components = null;
	private Customer selected_customer = null;
	private PurchaseOrder selected_order = null;
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
	private JButton btnRemover;
	private JButton btnAgregar;
	private JButton btnFacturar;
	private JRadioButton rdbtnCredito;
	private JSpinner spnEdad;
	private JSpinner spnCredito;
	private JButton btnRegistrarCliente;
	private JSpinner spnCantidad;

	private ArrayList<logico.Component> components = new ArrayList<logico.Component>();
	private ArrayList<logico.Combo> combos = new ArrayList<logico.Combo>();
	
	private JButton btnBuscarCliente;
	private JTable table_combos;
	private static DefaultTableModel model_combos;
	private JButton btnFacturarCombo;
	private static JButton btnModificarCombo;
	private static JButton btnEliminarCombo;
	private Combo selected_combo = null;
	private JButton btnConfirmarOrden;
	private JPanel grafica2;
	private JSpinner spnDiscoDuro;
	private JSpinner spnCpu;
	private JSpinner spnRam;
	private JSpinner spnMotherboard;
	private JComboBox cbxDiscoDuro;
	private JComboBox cbxCPU;
	private JComboBox cbxRAM;
	private JComboBox cbxMotherboard;
	private JSpinner spnDescuento;
	private JTextField txtCodigoCombo;
	private DefaultComboBoxModel motherboard_model;
	private DefaultComboBoxModel cpu_model;
	private DefaultComboBoxModel ram_model;
	private DefaultComboBoxModel hdd_model;
	private ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
	private ArrayList<CPU> cpus = new ArrayList<CPU>();
	private ArrayList<RAM> rams = new ArrayList<RAM>();
	private ArrayList<Drive> hdds = new ArrayList<Drive>();
	private ArrayList<logico.Component> combo_components = new ArrayList<logico.Component>();
	private JButton btnGenerarCombo;

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
	@SuppressWarnings("removal")
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
				int opc = JOptionPane.showConfirmDialog(null, "�Seguro que deseas salir del Sistema?",
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
				load_all();
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

		if ((Store.getLoggedUser() instanceof Administrator)) {
			labelLoggedUser = new JLabel(Store.getLoggedUser().getUsername() + " | Administrador");
		} else {
			labelLoggedUser = new JLabel(Store.getLoggedUser().getUsername() + " | Vendedor");
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

		JPanel pnlCombos = new JPanel();
		pnlCombos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlCombos.setBackground(Color.WHITE);
		pnlCombos.setBounds(52, 426, 626, 353);
		panelMenu.add(pnlCombos);
		pnlCombos.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		pnlCombos.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		panel.add(scrollPane_3, BorderLayout.CENTER);

		String combos_headers[] = { "C�digo", "Componente 1", "Componente 2", "Componente 3", "Componente 4",
				"Descuento" };
		// Se mostrar� as�: Motherboard xN CPU xN RAM xN Drive xN x% N = cantidad del
		// componente, x = % de descuento.
		model_combos = new DefaultTableModel();
		model_combos.setColumnIdentifiers(combos_headers);
		table_combos = new JTable();
		table_combos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = table_combos.getSelectedRow();
				if (index != -1) {
					btnModificarCombo.setEnabled(true);
					btnEliminarCombo.setEnabled(true);
					String codigo = (String) model_combos.getValueAt(index, 0);
					selected_combo = Store.getInstance().search_combo(codigo);
				}
			}
		});
		table_combos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_combos.setModel(model_combos);
		scrollPane_3.setViewportView(table_combos);

		grafica2 = new JPanel();
		grafica2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		grafica2.setBackground(Color.WHITE);
		grafica2.setBounds(782, 426, 626, 353);
		panelMenu.add(grafica2);
		grafica2.setLayout(new BorderLayout(0, 0));

//		PieDataset dataset = createDataset();
//		JFreeChart chart = createChart(dataset, "");
//		ChartPanel chartpanel = new ChartPanel(chart);
//		chartpanel.setPreferredSize(new java.awt.Dimension(800, 870));
//		ChartPanel chartPanel = new ChartPanel(chart);

		JButton btnVerGrafica = new JButton("Ver Grafica");
		btnVerGrafica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date fechaActual = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaActual);
				XYSeries datos = new XYSeries("Ventas en Total");

				float montoXDia = 0;

				for (int i = 1; i <= calendar.get(Calendar.DAY_OF_MONTH); i++) {
					montoXDia = 0;
					for (Invoice invoice : Store.getInstance().getInvoices()) {
						Calendar fechaFactura = Calendar.getInstance();
						fechaFactura.setTime(invoice.getDate());
						if (fechaFactura.get(Calendar.DAY_OF_MONTH) == i
								&& (fechaFactura.get(Calendar.MONTH) == (calendar.get(calendar.MONTH)+1) && fechaFactura.get(calendar.YEAR) == calendar.get(calendar.YEAR))) {
							montoXDia += invoice.get_total();
						}
					}
					datos.add(i, montoXDia);
				}

				XYSeriesCollection datosCollection = new XYSeriesCollection();
				datosCollection.addSeries(datos);
				JFreeChart chart = ChartFactory.createXYLineChart("Ventas del Mes", "Dias", "Acumulado",
						datosCollection);

				ChartPanel chartpanel = new ChartPanel(chart);
				chartpanel.setPreferredSize(new java.awt.Dimension(500, 550));
				JFrame informacion = new JFrame("Grafica");
				informacion.getContentPane().add(chartpanel);
				informacion.pack();
				informacion.setLocationRelativeTo(null);
				informacion.setVisible(true);

			}
		});
		btnVerGrafica.setForeground(Color.WHITE);
		btnVerGrafica.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnVerGrafica.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnVerGrafica.setBackground(new Color(102, 102, 255));
		btnVerGrafica.setAlignmentX(0.5f);
		grafica2.add(btnVerGrafica, BorderLayout.CENTER);

		JPanel panelComboSuperior1 = new JPanel();
		panelComboSuperior1.setLayout(null);
		panelComboSuperior1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelComboSuperior1.setBackground(new Color(102, 102, 255));
		panelComboSuperior1.setBounds(52, 366, 626, 63);
		panelMenu.add(panelComboSuperior1);

		JLabel lblCombos = new JLabel("Combos disponibles");
		lblCombos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombos.setForeground(Color.WHITE);
		lblCombos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblCombos.setBounds(10, 11, 606, 41);
		panelComboSuperior1.add(lblCombos);

		JPanel panelGraficoSuperior2 = new JPanel();
		panelGraficoSuperior2.setLayout(null);
		panelGraficoSuperior2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGraficoSuperior2.setBackground(new Color(102, 102, 255));
		panelGraficoSuperior2.setBounds(782, 366, 626, 63);
		panelMenu.add(panelGraficoSuperior2);

		JLabel Grafico2 = new JLabel("Ventas");
		Grafico2.setHorizontalAlignment(SwingConstants.CENTER);
		Grafico2.setForeground(Color.WHITE);
		Grafico2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		Grafico2.setBounds(10, 11, 606, 41);
		panelGraficoSuperior2.add(Grafico2);

		btnFacturarCombo = new JButton("Facturar Combo");
		btnFacturarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = JOptionPane.showInputDialog("Cedula del Cliente");
				
				Date dateCombo = new Date();
				Customer clienteCombo = Store.getInstance().search_customer(cedula);
				User seller = Store.getLoggedUser();
				boolean paid = false;
				boolean suficiente = true;
				Invoice invoice = new Invoice("" + Invoice.counter, dateCombo, seller, clienteCombo, paid);
				for (logico.Combo combo : combos) {
					combo.getComponents();
					for(logico.Component component : components) {
						invoice.addComponent(component);
					}
					
				}

				if (rdbtnCredito.isSelected()) {
					if (clienteCombo.getCredit() < invoice.get_total()) {
						JOptionPane.showMessageDialog(null,
								"El cliente no posee suficiente cr�dito para la compra. Por favor pagar en efectivo.",
								"Aviso", JOptionPane.WARNING_MESSAGE);
						suficiente = false;
					}
				} else {
					invoice.setPaid(true);
				}

				if (suficiente) {
					Store.getInstance().addInvoice(invoice);
					if (seller instanceof Seller) {
						((Seller) seller).setSold_amount(((Seller) seller).getSold_amount() + invoice.get_total());
					}
					if (rdbtnCredito.isSelected()) {
						clienteCombo.setCredit(clienteCombo.getCredit() - invoice.get_total());
					}
					for (logico.Component component : Store.getInstance().getComponents()) {
						for (logico.Component bought : invoice.getComponents()) {
							if (bought == component) {
								component.setAvailable(component.getAvailable() - 1);
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Factura generada exitosamente.", "Facturaci�n",
							JOptionPane.INFORMATION_MESSAGE);
					load_all();
				}
			}
		});
		btnFacturarCombo.setForeground(Color.WHITE);
		btnFacturarCombo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnFacturarCombo.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnFacturarCombo.setBackground(new Color(102, 102, 255));
		btnFacturarCombo.setAlignmentX(0.5f);
		btnFacturarCombo.setBounds(52, 792, 120, 28);
		panelMenu.add(btnFacturarCombo);

		btnModificarCombo = new JButton("Modificar Combo");
		btnModificarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

				Motherboard motherboard = null;
				CPU cpu = null;
				RAM ram = null;
				Drive drive = null;
				int cant_m = 0;
				int cant_cpu = 0;
				int cant_ram = 0;
				int cant_hdd = 0;

				txtCodigoCombo.setText(selected_combo.getCode());
				spnDescuento.setValue(selected_combo.getDiscount());
				for (logico.Component component : selected_combo.getComponents()) {
					if (component instanceof Motherboard) {
						if (motherboard == null) {
							motherboard = (Motherboard) component;
						}
						cant_m++;
					} else if (component instanceof CPU) {
						if (cpu == null) {
							cpu = (CPU) component;
						}
						cant_cpu++;
					} else if (component instanceof RAM) {
						if (ram == null) {
							ram = (RAM) component;
						}
						cant_ram++;
					} else if (component instanceof Drive) {
						if (drive == null) {
							drive = (Drive) component;
						}
						cant_hdd++;
					}
				}

				String name_motherboard = new String(
						motherboard.getSerial() + ". " + motherboard.getBrand() + " " + motherboard.getModel());
				cbxMotherboard.setSelectedItem(name_motherboard);
				spnMotherboard.setValue(cant_m);

				String name_cpu = new String(cpu.getSerial() + ". " + cpu.getBrand() + " " + cpu.getModel());
				cbxCPU.setSelectedItem(name_cpu);
				spnCpu.setValue(cant_cpu);

				String name_ram = new String(ram.getSerial() + ". " + ram.getBrand() + " " + ram.getType() + " "
						+ String.format(java.util.Locale.US, "%.2f", ram.getCapacity()) + " GB");
				cbxRAM.setSelectedItem(name_ram);
				spnRam.setValue(cant_ram);

				String name_hdd = new String(drive.getSerial() + ". " + drive.getBrand() + " " + drive.getModel() + " "
						+ String.format(java.util.Locale.US, "%.2f", drive.getStorage()) + " GB");
				cbxDiscoDuro.setSelectedItem(name_hdd);
				spnDiscoDuro.setValue(cant_hdd);
				btnGenerarCombo.setText("Modificar Combo");
				fill_comboboxes();
				load_component_arrays();
			}
		});
		btnModificarCombo.setForeground(Color.WHITE);
		btnModificarCombo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarCombo.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarCombo.setBackground(new Color(102, 102, 255));
		btnModificarCombo.setAlignmentX(0.5f);
		btnModificarCombo.setBounds(184, 792, 120, 28);
		if (!(Store.getLoggedUser() instanceof Administrator)) {
			btnModificarCombo.setVisible(false);
		}
		btnModificarCombo.setEnabled(false);
		panelMenu.add(btnModificarCombo);

		btnEliminarCombo = new JButton("Eliminar Combo");
		btnEliminarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,
						"Desea eliminar el combo " + selected_combo.getCode() + "?", "Eliminar Combo",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Store.getInstance().deleteCombo(selected_combo);
					load_combos();
				}
			}
		});
		btnEliminarCombo.setForeground(Color.WHITE);
		btnEliminarCombo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEliminarCombo.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnEliminarCombo.setBackground(new Color(102, 102, 255));
		btnEliminarCombo.setAlignmentX(0.5f);
		btnEliminarCombo.setBounds(316, 792, 120, 28);
		if (!(Store.getLoggedUser() instanceof Administrator)) {
			btnEliminarCombo.setVisible(false);
		}
		btnEliminarCombo.setEnabled(false);
		panelMenu.add(btnEliminarCombo);

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
					String headers[] = { "C�digo", "Nombre", "Nombre de usuario", "Contrase�a", "Tipo" };
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

		JLabel labelTituloUsuarios = new JLabel("USUARIOS"); // USUARIOS
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
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistry mod_user = new UserRegistry(selected_user);
				mod_user.setVisible(true);
			}
		});
		btnModificarUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarUsuario.setForeground(Color.WHITE);
		btnModificarUsuario.setBackground(new Color(102, 102, 255));
		btnModificarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarUsuario.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModificarUsuario.setBounds(1145, 70, 130, 28);
		panelUsuarios.add(btnModificarUsuario);

		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,
						"�Desea eliminar el usuario " + selected_user.getUsername() + "?", "Eliminar usuario",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Store.getInstance().deleteUser(selected_user);
					load_users();
				}
			}
		});
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

		JLabel labelTituloComponentes = new JLabel("COMPONENTES"); // COMPONENTES
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
				String headers[] = { "Serial", "Disponibilidad", "Marca", "Cant. Min.", "Cant. Max.", "Tipo",
						"Precio" };
				model_components = new DefaultTableModel();
				model_components.setColumnIdentifiers(headers);
				table_components = new JTable();
				table_components.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table_components.getSelectedRow();
						if (index != -1) {
							btnEliminarComponente.setEnabled(true);
							btnModificarComponente.setEnabled(true);
							String serial = (String) (model_components.getValueAt(index, 0));
							selected_components = Store.getInstance().search_component(serial);
						}
					}
				});
				table_components.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_components.setModel(model_components);
				scrollPane.setViewportView(table_components);
			}
		}

		btnEliminarComponente = new JButton("Eliminar");
		btnEliminarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,
						"�Desea eliminar el componente " + selected_components.getSerial() + "?", "Eliminar componente",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Store.getInstance().deleteComponent(selected_components);
					load_components();
				}
				btnEliminarComponente.setEnabled(false);
				btnModificarComponente.setEnabled(false);
			}
		});
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
		btnModificarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComponentsRegistry mod_component = new ComponentsRegistry(selected_components);
				mod_component.setVisible(true);
			}
		});
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
		btnNewComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComponentsRegistry component_reg = new ComponentsRegistry(null);
				component_reg.setVisible(true);
			}
		});
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

		JLabel labelTituloClientes = new JLabel("CLIENTES"); // CLIENTES
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
				String headers[] = { "C�dula", "Nombre", "Credito", "Edad" };
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
							String id = (String) (model_customers.getValueAt(index, 0));
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
				int option = JOptionPane.showConfirmDialog(null,
						"Desea eliminar el cliente:" + selected_customer.getId(), "Eliminar cliente",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Store.getInstance().deleteCustomer(selected_customer);
					load_customers();
				}
				btnEliminarCliente.setEnabled(false);
				btnModificarCliente.setEnabled(false);
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
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegistry aux = new CustomerRegistry(selected_customer);
				aux.setVisible(true);
			}
		});
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

		JLabel labelTituloFacturas = new JLabel("FACTURAS"); // FACTURAS
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
				String headers[] = { "C�digo", "Fecha", "Vendedor", "Cliente", "Monto total", "Pago Status" };
				model_invoices = new DefaultTableModel();
				model_invoices.setColumnIdentifiers(headers);
				table_invoices = new JTable();
				table_invoices.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table_invoices.getSelectedRow();
						if (index != -1) {
							String idInvoice = (String) (model_invoices.getValueAt(index, 0));
							selected_invoice = Store.getInstance().search_invoice(idInvoice);

							System.out.println(selected_invoice.isPaid());

							if (selected_invoice.isPaid() == false) {
								btnConfirmarPago.setEnabled(true);
							} else {
								btnConfirmarPago.setEnabled(false);
							}
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
		btnConfirmarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_invoice.setPaid(true);
				selected_invoice.getCustomer()
						.setCredit(selected_invoice.getCustomer().getCredit() + selected_invoice.get_total());
			}
		});
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
		labelTituloAdministracion.setForeground(new Color(102, 102, 255));
		labelTituloAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloAdministracion.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloAdministracion.setBounds(10, 0, 170, 40);
		panelAdministracion.add(labelTituloAdministracion);

		JPanel panelOrdenes = new JPanel();
		panelOrdenes.setBorder(new TitledBorder(null, "Ordenes de Compras para Componentes", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelOrdenes.setBounds(25, 100, 1410, 300);
		panelAdministracion.add(panelOrdenes);
		panelOrdenes.setLayout(null);

		JScrollPane scrollPaneOrdenes = new JScrollPane();
		scrollPaneOrdenes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneOrdenes.setBounds(15, 25, 1000, 250);
		panelOrdenes.add(scrollPaneOrdenes);
		{
			String headers[] = { "C�digo", "Fecha", "Componente", "Cantidad", "Status" };
			model_ordersPurchase = new DefaultTableModel();
			model_ordersPurchase.setColumnIdentifiers(headers);
			table_ordersPurchase = new JTable();
			table_ordersPurchase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = table_ordersPurchase.getSelectedRow();
					if (index != -1) {
						String idOrder = (String) (model_ordersPurchase.getValueAt(index, 0));
						selected_order = Store.getInstance().search_orderPurchase(idOrder);
						if (selected_order.isDone() == false) {
							btnConfirmarOrden.setEnabled(true);
						} else {
							btnConfirmarOrden.setEnabled(false);
						}
					}
				}
			});
			table_ordersPurchase.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_ordersPurchase.setModel(model_ordersPurchase);
			scrollPaneOrdenes.setViewportView(table_ordersPurchase);
		}

		btnConfirmarOrden = new JButton("Confirmar Orden");
		btnConfirmarOrden.setEnabled(false);
		btnConfirmarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Store.getInstance().efectuarOrdenDeCompra(selected_order);
				load_all();
				JOptionPane.showMessageDialog(null, "Se efectua la orden de compra!.", "Orden de Compra",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnConfirmarOrden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarOrden.setForeground(Color.WHITE);
		btnConfirmarOrden.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnConfirmarOrden.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnConfirmarOrden.setBackground(new Color(102, 102, 255));
		btnConfirmarOrden.setAlignmentX(0.5f);
		btnConfirmarOrden.setBounds(1060, 25, 300, 28);
		panelOrdenes.add(btnConfirmarOrden);

		JPanel panelCombosComponentes = new JPanel();
		panelCombosComponentes.setLayout(null);
		panelCombosComponentes.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Armar Combos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCombosComponentes.setBounds(25, 450, 1410, 300);
		panelAdministracion.add(panelCombosComponentes);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCodigo.setBounds(0, 18, 158, 40);
		panelCombosComponentes.add(lblCodigo);

		txtCodigoCombo = new JTextField();
		txtCodigoCombo.setEditable(false);
		txtCodigoCombo.setText(Store.getInstance().autogenerateId());
		txtCodigoCombo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtCodigoCombo.setBounds(160, 30, 170, 23);
		panelCombosComponentes.add(txtCodigoCombo);
		txtCodigoCombo.setColumns(10);

		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDescuento.setBounds(380, 18, 158, 40);
		panelCombosComponentes.add(lblDescuento);

		spnDescuento = new JSpinner();
		spnDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnDescuento.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		spnDescuento.setBounds(540, 30, 170, 23);
		panelCombosComponentes.add(spnDescuento);

		JLabel lblMotherBoard = new JLabel("Motherboard:");
		lblMotherBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotherBoard.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblMotherBoard.setBounds(0, 78, 158, 40);
		panelCombosComponentes.add(lblMotherBoard);

		JLabel lblCpu = new JLabel("CPU:");
		lblCpu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCpu.setBounds(380, 78, 158, 40);
		panelCombosComponentes.add(lblCpu);

		JLabel lblRam = new JLabel("RAM:");
		lblRam.setHorizontalAlignment(SwingConstants.CENTER);
		lblRam.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblRam.setBounds(0, 138, 158, 40);
		panelCombosComponentes.add(lblRam);

		JLabel lblDiscoDuro = new JLabel("Disco Duro:");
		lblDiscoDuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscoDuro.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDiscoDuro.setBounds(380, 138, 158, 40);
		panelCombosComponentes.add(lblDiscoDuro);

		cbxMotherboard = new JComboBox();
		cbxMotherboard.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					String code = item.substring(0, item.indexOf('.'));
					Motherboard motherboard = (Motherboard) Store.getInstance().search_component(code);

					for (CPU cpu : cpus) {
						if (!(motherboard.getSocket().equalsIgnoreCase(cpu.getSocket()))) {
							cpus.remove(cpu);
						}
					}

					for (RAM ram : rams) {
						if (!(motherboard.getCompatible_RAM().equalsIgnoreCase(ram.getType()))) {
							rams.remove(ram);
						}
					}

					for (Drive drive : hdds) {
						if (!(motherboard.getCompatible_hdds().contains(drive.getConnector()))) {
							hdds.remove(drive);
						}
					}
					fill_comboboxes();
					load_component_arrays();

				}
			}
		});
		cbxMotherboard.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		cbxMotherboard.setBounds(160, 90, 170, 23);
		panelCombosComponentes.add(cbxMotherboard);

		cbxRAM = new JComboBox();
		cbxRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					String code = item.substring(0, item.indexOf('.'));
					RAM ram = (RAM) Store.getInstance().search_component(code);

					for (Motherboard motherboard : motherboards) {
						if (!(ram.getType().equalsIgnoreCase(motherboard.getCompatible_RAM()))) {
							motherboards.remove(motherboard);
						}
					}
					fill_comboboxes();
					load_component_arrays();
				}
			}
		});
		cbxRAM.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		cbxRAM.setBounds(160, 150, 170, 23);
		panelCombosComponentes.add(cbxRAM);

		cbxCPU = new JComboBox();
		cbxCPU.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					String code = item.substring(0, item.indexOf('.'));
					CPU cpu = (CPU) Store.getInstance().search_component(code);

					for (Motherboard motherboard : motherboards) {
						if (!(cpu.getSocket().equalsIgnoreCase(motherboard.getSocket()))) {
							motherboards.remove(motherboard);
						}
					}
					fill_comboboxes();
					load_component_arrays();
				}
			}
		});
		cbxCPU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		cbxCPU.setBounds(540, 90, 170, 23);
		panelCombosComponentes.add(cbxCPU);

		cbxDiscoDuro = new JComboBox();
		cbxDiscoDuro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					String code = item.substring(0, item.indexOf('.'));
					Drive drive = (Drive) Store.getInstance().search_component(code);

					for (Motherboard motherboard : motherboards) {
						if (!(motherboard.getCompatible_hdds().contains(drive.getConnector()))) {
							motherboards.remove(motherboard);
						}
					}
					fill_comboboxes();
					load_component_arrays();
				}
			}
		});
		cbxDiscoDuro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		cbxDiscoDuro.setBounds(540, 150, 170, 23);
		panelCombosComponentes.add(cbxDiscoDuro);

		spnMotherboard = new JSpinner();
		spnMotherboard.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMotherboard.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		spnMotherboard.setBounds(335, 90, 35, 23);
		panelCombosComponentes.add(spnMotherboard);

		spnRam = new JSpinner();
		spnRam.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnRam.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		spnRam.setBounds(335, 150, 35, 23);
		panelCombosComponentes.add(spnRam);

		spnCpu = new JSpinner();
		spnCpu.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCpu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		spnCpu.setBounds(715, 90, 35, 23);
		panelCombosComponentes.add(spnCpu);

		spnDiscoDuro = new JSpinner();
		spnDiscoDuro.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnDiscoDuro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		spnDiscoDuro.setBounds(715, 150, 35, 23);
		panelCombosComponentes.add(spnDiscoDuro);

		btnGenerarCombo = new JButton("Generar Combo");
		btnGenerarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = cbxMotherboard.getSelectedItem().toString();
				String code = item.substring(0, item.indexOf('.'));
				Motherboard motherboard = (Motherboard) Store.getInstance().search_component(code);
				for (int i = 0; i < Integer.valueOf(spnMotherboard.getValue().toString()); i++) {
					combo_components.add(motherboard);
				}

				item = cbxCPU.getSelectedItem().toString();
				code = item.substring(0, item.indexOf('.'));
				CPU cpu = (CPU) Store.getInstance().search_component(code);
				for (int i = 0; i < Integer.valueOf(spnCpu.getValue().toString()); i++) {
					combo_components.add(cpu);
				}

				item = cbxRAM.getSelectedItem().toString();
				code = item.substring(0, item.indexOf('.'));
				RAM ram = (RAM) Store.getInstance().search_component(code);
				for (int i = 0; i < Integer.valueOf(spnRam.getValue().toString()); i++) {
					combo_components.add(ram);
				}

				item = cbxDiscoDuro.getSelectedItem().toString();
				code = item.substring(0, item.indexOf('.'));
				Drive drive = (Drive) Store.getInstance().search_component(code);
				for (int i = 0; i < Integer.valueOf(spnDiscoDuro.getValue().toString()); i++) {
					combo_components.add(drive);
				}

				if (selected_combo == null) {
					Combo combo = new Combo(txtCodigoCombo.getText(), combo_components,
							Float.valueOf(spnDescuento.getValue().toString()));
					Store.getInstance().addCombo(combo);
					JOptionPane.showMessageDialog(null, "Combo creado satisfactoriamente.", "Creaci�n de combo",
							JOptionPane.INFORMATION_MESSAGE);
					combo_components.clear();
					fill_comboboxes();
					clean_combos();
					load_combos();
				} else {
					int index = Store.getInstance().getCombos().indexOf(selected_combo);
					selected_combo.setCode(txtCodigoCombo.getText());
					selected_combo.setComponents(combo_components);
					selected_combo.setDiscount(Float.valueOf(spnDescuento.getValue().toString()));
					Store.getInstance().getCombos().set(index, selected_combo);
					JOptionPane.showMessageDialog(null, "El combo ha sido modificado.", "Modificar Combo",
							JOptionPane.INFORMATION_MESSAGE);
					combo_components.clear();
					load_all();
					fill_comboboxes();
					clean_combos();
					load_combos();
				}
			}
		});
		btnGenerarCombo.setForeground(Color.WHITE);
		btnGenerarCombo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnGenerarCombo.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnGenerarCombo.setBackground(new Color(102, 102, 255));
		btnGenerarCombo.setAlignmentX(0.5f);
		btnGenerarCombo.setBounds(1060, 30, 300, 28);
		panelCombosComponentes.add(btnGenerarCombo);

		JSeparator separator_1_2_2_1 = new JSeparator();
		separator_1_2_2_1.setForeground(new Color(211, 211, 211));
		separator_1_2_2_1.setBounds(0, 40, 1457, 11);
		panelAdministracion.add(separator_1_2_2_1);

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
		txtBuscadorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cliente = Store.getInstance().search_customer(txtBuscadorCliente.getText());
				if (cliente != null) {
					txtCedula.setEditable(false);
					txtCedula.setText(cliente.getId());
					txtNombre.setEditable(false);
					txtNombre.setText(cliente.getName());
					spnEdad.setValue(cliente.getAge());
					spnEdad.setEnabled(false);
					spnCredito.setValue(cliente.getCredit());
					spnCredito.setEnabled(false);
					btnRegistrarCliente.setEnabled(false);
				} else {
					txtCedula.setEditable(true);
					txtCedula.setText(txtBuscadorCliente.getText());
					txtNombre.setEditable(true);
					spnEdad.setEnabled(true);
					spnCredito.setEnabled(true);
					btnRegistrarCliente.setEnabled(true);
				}
			}
		});
		txtBuscadorCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		txtBuscadorCliente.setBounds(167, 85, 150, 23);
		panelTienda.add(txtBuscadorCliente);
		txtBuscadorCliente.setColumns(10);

		JPanel panelFormularioCliente = new JPanel();
		panelFormularioCliente.setBorder(
				new TitledBorder(null, "Formulario Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnEdad.setEnabled(false);
		spnEdad.setBounds(724, 39, 150, 23);
		panelFormularioCliente.add(spnEdad);

		JLabel labelCredito = new JLabel("Credito:");
		labelCredito.setHorizontalAlignment(SwingConstants.CENTER);
		labelCredito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		labelCredito.setBounds(900, 30, 158, 40);
		panelFormularioCliente.add(labelCredito);

		spnCredito = new JSpinner();
		spnCredito.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1000)));
		spnCredito.setEnabled(false);
		spnCredito.setBounds(1016, 39, 150, 23);
		panelFormularioCliente.add(spnCredito);

		btnRegistrarCliente = new JButton("Registrar Cliente");
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cliente = new Customer(txtCedula.getText(), txtNombre.getText(),
						Float.valueOf(spnCredito.getValue().toString()),
						Integer.valueOf(spnEdad.getValue().toString()));
				Store.getInstance().addCustomer(cliente);
				JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente.", "Registro de cliente",
						JOptionPane.INFORMATION_MESSAGE);
				load_all();
			}
		});
		btnRegistrarCliente.setForeground(Color.WHITE);
		btnRegistrarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnRegistrarCliente.setEnabled(false);
		btnRegistrarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnRegistrarCliente.setBackground(new Color(102, 102, 255));
		btnRegistrarCliente.setAlignmentX(0.5f);
		btnRegistrarCliente.setBounds(1230, 34, 130, 28);
		panelFormularioCliente.add(btnRegistrarCliente);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(25, 350, 550, 400);
		panelTienda.add(scrollPane_2);

		list_almacen = new JList<String>();
		list_almacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = list_almacen.getSelectedIndex();
				if (index != -1) {
					spnCantidad.setEnabled(true);
					btnAgregar.setEnabled(true);
				}
			}
		});
		list_almacen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModelAlmacen = new DefaultListModel<String>();
		list_almacen.setModel(listModelAlmacen);
		scrollPane_2.setViewportView(list_almacen);

		JLabel lblProductosEnAlmacen = new JLabel("Productos en Almacen");
		lblProductosEnAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosEnAlmacen.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblProductosEnAlmacen.setBounds(25, 315, 165, 40);
		panelTienda.add(lblProductosEnAlmacen);

		btnAgregar = new JButton(">>>");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = list_almacen.getSelectedValue().toString();
				String code = aux.substring(0, aux.indexOf('.'));
				int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
				logico.Component component = Store.getInstance().search_component(code);
				if (cantidad >= component.getAvailable()) {
					cantidad = component.getAvailable();
					listModelAlmacen.remove(list_almacen.getSelectedIndex());
				}
				aux.concat(" x" + spnCantidad.getValue().toString());
				listModelCarrito.addElement(aux);
				for (int i = 0; i < cantidad; i++) {
					components.add(component);
				}
				btnAgregar.setEnabled(false);
				spnCantidad.setValue(1);
				spnCantidad.setEnabled(false);
			}
		});
		btnAgregar.setEnabled(false);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnAgregar.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnAgregar.setBackground(new Color(102, 102, 255));
		btnAgregar.setAlignmentX(0.5f);
		btnAgregar.setBounds(680, 499, 120, 28);
		panelTienda.add(btnAgregar);

		btnRemover = new JButton("<<<");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// boolean inAlmacen = false;
				String aux = list_carrito.getSelectedValue().toString();
				String code = aux.substring(0, aux.indexOf('.'));
				/*
				 * for (int i = 0; i < listModelAlmacen.getSize(); i++) { String aux2 =
				 * listModelAlmacen.getElementAt(i); String code2 = aux2.substring(0,
				 * aux2.indexOf(' ')); if(code.equalsIgnoreCase(code2)) { inAlmacen = true;
				 * break; } } if(!inAlmacen) { String back = aux.substring(0,
				 * aux.indexOf('x')-1); listModelAlmacen.addElement(back); }
				 */
				listModelCarrito.remove(list_carrito.getSelectedIndex());
				logico.Component removing = Store.getInstance().search_component(code);
				if (!components.isEmpty()) {
					for (logico.Component component : components) {
						if (component == removing) {
							components.remove(component);
						}
					}
				}
				btnRemover.setEnabled(false);
				load_almacen();
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnRemover.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnRemover.setBackground(new Color(102, 102, 255));
		btnRemover.setAlignmentX(0.5f);
		btnRemover.setBounds(680, 599, 120, 28);
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
				if (index != -1) {
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
		btnFacturar.setEnabled(false);
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCedula.getText() == "") {
					JOptionPane.showMessageDialog(null, "Debe elegir un cliente primero.", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else if (listModelCarrito.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un componente.", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Date date = new Date();
					Customer cliente = Store.getInstance().search_customer(txtCedula.getText());
					User seller = Store.getLoggedUser();
					boolean paid = false;
					boolean suficiente = true;
					Invoice invoice = new Invoice("" + Invoice.counter, date, seller, cliente, paid);
					for (logico.Component component : components) {
						invoice.addComponent(component);
					}

					if (rdbtnCredito.isSelected()) {
						if (cliente.getCredit() < invoice.get_total()) {
							JOptionPane.showMessageDialog(null,
									"El cliente no posee suficiente cr�dito para la compra. Por favor pagar en efectivo.",
									"Aviso", JOptionPane.WARNING_MESSAGE);
							suficiente = false;
						}
					} else {
						invoice.setPaid(true);
					}

					if (suficiente) {
						Store.getInstance().addInvoice(invoice);
						if (seller instanceof Seller) {
							((Seller) seller).setSold_amount(((Seller) seller).getSold_amount() + invoice.get_total());
						}
						if (rdbtnCredito.isSelected()) {
							cliente.setCredit(cliente.getCredit() - invoice.get_total());
						}
						for (logico.Component component : Store.getInstance().getComponents()) {
							for (logico.Component bought : invoice.getComponents()) {
								if (bought == component) {
									component.setAvailable(component.getAvailable() - 1);
								}
							}
						}
						JOptionPane.showMessageDialog(null, "Factura generada exitosamente.", "Facturaci�n",
								JOptionPane.INFORMATION_MESSAGE);
						clean_tienda();
						load_all();
					}
				}

			}
		});
		btnFacturar.setForeground(Color.WHITE);
		btnFacturar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnFacturar.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnFacturar.setBackground(new Color(102, 102, 255));
		btnFacturar.setAlignmentX(0.5f);
		btnFacturar.setBounds(1315, 785, 120, 28);
		panelTienda.add(btnFacturar);

		rdbtnCredito = new JRadioButton("Compra a Credito");
		rdbtnCredito.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		rdbtnCredito.setBounds(1150, 785, 145, 28);
		panelTienda.add(rdbtnCredito);

		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(650, 436, 56, 16);
		panelTienda.add(lblNewLabel);

		spnCantidad = new JSpinner();
		spnCantidad.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		spnCantidad.setEnabled(false);
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));

		spnCantidad.setBounds(718, 433, 82, 22);
		panelTienda.add(spnCantidad);

		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cliente = Store.getInstance().search_customer(txtBuscadorCliente.getText());
				if (cliente != null) {
					txtCedula.setEditable(false);
					txtCedula.setText(cliente.getId());
					txtNombre.setEditable(false);
					txtNombre.setText(cliente.getName());
					spnEdad.setValue(cliente.getAge());
					spnEdad.setEnabled(false);
					spnCredito.setValue(cliente.getCredit());
					spnCredito.setEnabled(false);
					btnRegistrarCliente.setEnabled(false);
				} else {
					txtCedula.setEditable(true);
					txtCedula.setText(txtBuscadorCliente.getText());
					txtNombre.setEditable(true);
					spnEdad.setEnabled(true);
					spnCredito.setEnabled(true);
					btnRegistrarCliente.setEnabled(true);
				}
			}
		});
		btnBuscarCliente.setForeground(Color.WHITE);
		btnBuscarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnBuscarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnBuscarCliente.setBackground(new Color(102, 102, 255));
		btnBuscarCliente.setAlignmentX(0.5f);
		btnBuscarCliente.setBounds(360, 82, 120, 28);
		panelTienda.add(btnBuscarCliente);

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
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hiloContadores = new Thread(runnableContadores);
		hiloContadores.start();

//		HILO PARA REFRESCAR BOTON FACTURAR
		Runnable runnableCarritoCompra = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						int size = listModelCarrito.getSize();
						if (size > 0) {
							btnFacturar.setEnabled(true);
						} else {
							btnFacturar.setEnabled(false);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hiloCarritoCompra = new Thread(runnableCarritoCompra);
		hiloCarritoCompra.start();

//		HILO PARA GENERAR ORDENES DE COMPRAS
		Runnable runnableGenerarOrden = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						Store.getInstance().crearOrdenCompra();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hiloGenerarOrden = new Thread(runnableGenerarOrden);
		hiloGenerarOrden.start();

//		HILO PARA REFRESCAR GRAFICOS 
		Runnable runnableGraficos = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10000);
						Date fechaActual = new Date();
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(fechaActual);
						XYSeries datos = new XYSeries("Ventas en Total");

						float montoXDia = 0;

						for (int i = 1; i <= calendar.get(Calendar.DAY_OF_MONTH); i++) {
							montoXDia = 0;
							for (Invoice invoice : Store.getInstance().getInvoices()) {
								Calendar fechaFactura = Calendar.getInstance();
								fechaFactura.setTime(invoice.getDate());
								if (fechaFactura.get(Calendar.DAY_OF_MONTH) == i
										&& (fechaFactura.get(Calendar.MONTH) == (calendar.get(calendar.MONTH)+1) && fechaFactura.get(calendar.YEAR) == calendar.get(calendar.YEAR))) {
									montoXDia += invoice.get_total();
								}
							}
							datos.add(i, montoXDia);
						}

						XYSeriesCollection datosCollection = new XYSeriesCollection();
						datosCollection.addSeries(datos);
						JFreeChart chart = ChartFactory.createXYLineChart("Ventas del Mes", "Dias", "Acumulado",
								datosCollection);

						ChartPanel chartpanel = new ChartPanel(chart);
						chartpanel.setPreferredSize(new java.awt.Dimension(500, 550));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hiloGraficos = new Thread(runnableGraficos);
		hiloGraficos.start();

		load_all();
		/*
		 * load_users(); load_customers(); load_almacen(); etc.
		 */
	}
	

	public void load_all() {

		clean_tienda();
		load_users();
		load_customers();
		load_components();
		load_invoices();
		load_combos();
		load_orders();
		load_component_arrays();
		fill_comboboxes();

	}

	private void fill_comboboxes() {
		fill_motherboards();
		fill_cpus();
		fill_rams();
		fill_hdds();
	}

	private void fill_rams() {
		String[] ram_items = new String[rams.size()];
		for (int i = 0; i < rams.size(); i++) {
			ram_items[i] = rams.get(i).getSerial() + ". " + rams.get(i).getBrand() + " " + rams.get(i).getType()
					+ " " + String.format(java.util.Locale.US, "%.2f", rams.get(i).getCapacity()) + " GB";
		}
		ram_model = new DefaultComboBoxModel(ram_items);
		cbxRAM.setModel(ram_model);
	}

	private void fill_motherboards() {
		String[] motherboard_items = new String[motherboards.size()];
		for (int i = 0; i < motherboards.size(); i++) {
			motherboard_items[i] = motherboards.get(i).getSerial() + ". " + motherboards.get(i).getBrand() + " "
					+ motherboards.get(i).getModel();
		}
		motherboard_model = new DefaultComboBoxModel(motherboard_items);
		cbxMotherboard.setModel(motherboard_model);
	}

	private void fill_cpus() {
		String[] cpu_items = new String[cpus.size()];
		for (int i = 0; i < cpus.size(); i++) {
			cpu_items[i] = cpus.get(i).getSerial() + ". " + cpus.get(i).getBrand() + " " + cpus.get(i).getModel();
		}
		cpu_model = new DefaultComboBoxModel(cpu_items);
		cbxCPU.setModel(cpu_model);
	}

	private void fill_hdds() {
		String[] hdd_items = new String[hdds.size()];
		for (int i = 0; i < hdds.size(); i++) {
			hdd_items[i] = hdds.get(i).getSerial() + ". " + hdds.get(i).getBrand() + " "
					+ String.format(java.util.Locale.US, "%.2f", hdds.get(i).getStorage()) + " GB";
		}
		hdd_model = new DefaultComboBoxModel(hdd_items);
		cbxDiscoDuro.setModel(hdd_model);
	}

	public static void load_combos() {
		model_combos.setRowCount(0);
		rows = new Object[model_combos.getColumnCount()];
		for (Combo combo : Store.getInstance().getCombos()) {
			Motherboard motherboard = null;
			CPU cpu = null;
			RAM ram = null;
			Drive drive = null;
			int cant_motherboard = 0;
			int cant_cpu = 0;
			int cant_ram = 0;
			int cant_hdd = 0;
			for (logico.Component component : combo.getComponents()) {
				if (component instanceof Motherboard) {
					cant_motherboard++;
					if (motherboard == null) {
						motherboard = (Motherboard) component;
					}
				} else if (component instanceof CPU) {
					cant_cpu++;
					if (cpu == null) {
						cpu = (CPU) component;
					}
				} else if (component instanceof RAM) {
					cant_ram++;
					if (ram == null) {
						ram = (RAM) component;
					}
				} else if (component instanceof Drive) {
					cant_hdd++;
					if (drive == null) {
						drive = (Drive) component;
					}
				}
			}

			rows[0] = combo.getCode();
			rows[1] = "" + motherboard + " x" + cant_motherboard;
			rows[2] = "" + cpu + " x" + cant_cpu;
			rows[3] = "" + ram + " x" + cant_ram;
			rows[4] = "" + drive + " x" + cant_hdd;
			rows[5] = combo.getDiscount();

			model_combos.addRow(rows);
		}
		btnEliminarCombo.setEnabled(false);
		btnModificarCombo.setEnabled(false);

	}

	private void load_component_arrays() {
		for (logico.Component component : Store.getInstance().getComponents()) {
			if (component instanceof Motherboard) {
				if (!(motherboards.contains(component))) {
					motherboards.add((Motherboard) component);
				}
			} else if (component instanceof CPU) {
				if (!(cpus.contains(component))) {
					cpus.add((CPU) component);
				}
			} else if (component instanceof RAM) {
				if (!(rams.contains(component))) {
					rams.add((RAM) component);
				}
			} else if (component instanceof Drive) {
				if (!(hdds.contains(component))) {
					hdds.add((Drive) component);
				}
			}
		}
	}

	private void load_almacen() {
		listModelAlmacen.removeAllElements();
		listModelCarrito.removeAllElements();
		for (logico.Component component : Store.getInstance().getComponents()) {
			String type = null;
			if (component instanceof Drive) {
				type = "Drive";
			} else if (component instanceof CPU) {
				type = "Processor";
			} else if (component instanceof Motherboard) {
				type = "Motherboard";
			} else if (component instanceof RAM) {
				type = "RAM memory";
			}
			// Aqu� debe mostrarse algo como: "009138173. Intel Processor"
			String show = new String(component.getSerial() + ". " + component.getBrand() + " " + type);
			listModelAlmacen.addElement(show);
		}

	}

	protected void clean_tienda() {
		txtBuscadorCliente.setText("");
		txtCedula.setText("");
		txtCedula.setEditable(false);
		txtNombre.setText("");
		txtNombre.setEditable(false);
		spnEdad.setValue(0);
		spnEdad.setEnabled(false);
		spnCredito.setValue(0);
		spnCredito.setEnabled(false);
		btnRegistrarCliente.setEnabled(false);
		rdbtnCredito.setSelected(false);
		components.clear();
		load_almacen();
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
			model_customers.addRow(rows);
		}

		btnEliminarUsuario.setEnabled(false);
		btnModificarUsuario.setEnabled(false);
	}

	public static void load_components() {
		model_components.setRowCount(0);
		rows = new Object[model_components.getColumnCount()];
		for (logico.Component component : Store.getInstance().getComponents()) {
			rows[0] = component.getSerial();
			rows[1] = component.getAvailable();
			rows[2] = component.getBrand();
			rows[3] = component.getMin_amount();
			rows[4] = component.getMax_amount();
			if (component instanceof Motherboard) {
				rows[5] = "Tarjeta madre";
			}
			if (component instanceof CPU) {
				rows[5] = "CPU";
			}
			if (component instanceof RAM) {
				rows[5] = "RAM";
			}
			if (component instanceof Drive) {
				rows[5] = "Drive";
			}
			rows[6] = component.getPrice();

			model_components.addRow(rows);
		}
	}

	public static void load_invoices() {
		model_invoices.setRowCount(0);
		rows = new Object[model_invoices.getColumnCount()];
		for (Invoice invoices : Store.getInstance().getInvoices()) {
			String pagadoStatus = "";
			if (invoices.isPaid()) {
				pagadoStatus = "Pagado";
			} else {
				pagadoStatus = "A Credito";
			}

			rows[0] = invoices.getCode();
			rows[1] = invoices.getDate();
			rows[2] = invoices.getSeller().getUsername();
			rows[3] = invoices.getCustomer();
			rows[4] = invoices.get_total();
			rows[5] = pagadoStatus;

			model_invoices.addRow(rows);
		}

	}

	public static void load_orders() {
		model_ordersPurchase.setRowCount(0);
		rows = new Object[model_ordersPurchase.getColumnCount()];

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		for (PurchaseOrder orders : Store.getInstance().getOrders()) {
			String ordenStatus = "";
			if (orders.isDone()) {
				ordenStatus = "Completado";
			} else {
				ordenStatus = "En Espera";
			}
			rows[0] = orders.getCode();
			rows[1] = dt.format(orders.getDate());
			rows[2] = orders.getComponent().getBrand();
			rows[3] = orders.getAmount();
			rows[4] = ordenStatus;

			model_ordersPurchase.addRow(rows);
		}

	}


	private void clean_combos() {
		txtCodigoCombo.setText(Store.getInstance().autogenerateId());
		spnDescuento.setValue(0);
		cbxMotherboard.setSelectedIndex(0);
		spnMotherboard.setValue(0);
		cbxCPU.setSelectedIndex(0);
		spnCpu.setValue(0);
		cbxRAM.setSelectedIndex(0);
		spnRam.setValue(0);
		cbxDiscoDuro.setSelectedIndex(0);
		spnDiscoDuro.setValue(0);
		btnGenerarCombo.setText("Generar Combo");
	}

}
