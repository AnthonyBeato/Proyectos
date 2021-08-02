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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.Store;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
	
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private JButton btnModificarCliente;
	private JButton btnEliminarCliente;
	private JButton btnNewCliente;

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
		AdministracionOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(false);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(true);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
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
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
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
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
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
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			}
		});
		ComponentesOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ComponentesOPC.setHorizontalAlignment(SwingConstants.CENTER);
		ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		ComponentesOPC.setBounds(46, 326, 154, 27);
		MenuLateral.add(ComponentesOPC);

		UsuariosOPC = new JLabel("Usuarios");
		UsuariosOPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelUsuarios.setVisible(true);
				panelMenu.setVisible(false);
				panelAdministracion.setVisible(false);
				panelClientes.setVisible(false);
				panelComponentes.setVisible(false);
				panelFacturas.setVisible(false);
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			}
		});
		UsuariosOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UsuariosOPC.setHorizontalAlignment(SwingConstants.CENTER);
		UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		UsuariosOPC.setBounds(46, 288, 154, 27);
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
				
				UsuariosOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				MenuOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
				FacturasOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ComponentesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
				ClientesOPC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
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

		JLabel lblNewLabel_2_2_1 = new JLabel("Usuario | Administrador");
		lblNewLabel_2_2_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(46, 740, 154, 27);
		MenuLateral.add(lblNewLabel_2_2_1);

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

		JLabel lblNewLabel_3 = new JLabel("22");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(152, 0, 90, 51);
		panelClienteDatos.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Atendidos");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(152, 27, 110, 40);
		panelClienteDatos.add(lblNewLabel_3_1);
		
		// ICONO DE VISTA CLIENTES
		JLabel IconoClientes = new JLabel("");
		IconoClientes.setBounds(67, 11, 50, 50);
		ImageIcon icoClientes = new ImageIcon(getClass().getResource("/Img/cliente.png"));
		ImageIcon imgClientes = new ImageIcon(icoClientes.getImage().getScaledInstance(IconoClientes.getWidth(), IconoClientes.getHeight(), Image.SCALE_SMOOTH));
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
		ImageIcon imgComponentes = new ImageIcon(icoComponentes.getImage().getScaledInstance(IconoLabelComponentes.getWidth(), IconoLabelComponentes.getHeight(), Image.SCALE_SMOOTH));
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

		JLabel lblNewLabel_3_2 = new JLabel("10");
		lblNewLabel_3_2.setBounds(152, 0, 90, 51);
		panelComponentesDatos.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));

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

		JLabel lblNewLabel_3_3 = new JLabel("3");
		lblNewLabel_3_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(152, 0, 90, 51);
		panelUsuariosDatos.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_1_2 = new JLabel("Registrados");
		lblNewLabel_3_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_2.setBounds(152, 27, 110, 40);
		panelUsuariosDatos.add(lblNewLabel_3_1_2);

		JLabel IconoLabelUsuarios = new JLabel("");
		IconoLabelUsuarios.setBounds(67, 11, 50, 50);
		ImageIcon icoUsuarios = new ImageIcon(getClass().getResource("/Img/usuario.png"));
		ImageIcon imgUsuarios = new ImageIcon(icoUsuarios.getImage().getScaledInstance(IconoLabelUsuarios.getWidth(), IconoLabelUsuarios.getHeight(), Image.SCALE_SMOOTH));
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

		JLabel lblNewLabel_3_4 = new JLabel("22");
		lblNewLabel_3_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_4.setBounds(152, 0, 90, 51);
		panelFacturaDatos.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_1_3 = new JLabel("Generadas");
		lblNewLabel_3_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_3.setBounds(152, 27, 110, 40);
		panelFacturaDatos.add(lblNewLabel_3_1_3);

		JLabel IconoLabelFacturas = new JLabel("");
		IconoLabelFacturas.setBounds(70, 11, 50, 50);
		ImageIcon icoFactura = new ImageIcon(getClass().getResource("/Img/factura.png"));
		ImageIcon imgFactura = new ImageIcon(icoFactura.getImage().getScaledInstance(IconoLabelFacturas.getWidth(), IconoLabelFacturas.getHeight(), Image.SCALE_SMOOTH));
		IconoLabelFacturas.setIcon(imgFactura);
		
		panelFacturaDatos.add(IconoLabelFacturas);

		JPanel grafica1 = new JPanel();
		grafica1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		grafica1.setBackground(Color.WHITE);
		grafica1.setBounds(52, 366, 626, 413);
		panelMenu.add(grafica1);

		JPanel grafica2 = new JPanel();
		grafica2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		grafica2.setBackground(Color.WHITE);
		grafica2.setBounds(782, 366, 626, 413);
		panelMenu.add(grafica2);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBounds(247, 0, 1457, 841);
		contentPane.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		{
			JPanel panelTabla = new JPanel();
			panelTabla.setSize(1410, 700);
			panelTabla.setLocation(25, 125);
			panelTabla.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelUsuarios.add(panelTabla, BorderLayout.CENTER);
			panelTabla.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panelTabla.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Código","Nombre","Teléfono","Dirección"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = -1;
							index = table.getSelectedRow();
							if(index != -1) {
//								btnEliminar.setEnabled(true);
//								btnModificar.setEnabled(true);
//								String id = (String)(model.getValueAt(index, 0));
//								selected = Controladora.getInstance().buscarClienteEspecificoByID(id);
//								System.out.println(selected.getCedula()+""+selected.getNombre());
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
			
		}
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(211, 211, 211));
		separator_1.setBounds(0, 40, 1457, 11);
		panelUsuarios.add(separator_1);
		
		JLabel labelTituloUsuarios = new JLabel("USUARIOS");
		labelTituloUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloUsuarios.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		labelTituloUsuarios.setBounds(10, 0, 100, 40);
		panelUsuarios.add(labelTituloUsuarios);
		
		btnNewCliente = new JButton("Nuevo Cliente");
		btnNewCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewCliente.setForeground(Color.WHITE);
		btnNewCliente.setBackground(new Color(102, 102, 255));
		btnNewCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnNewCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewCliente.setBounds(1300, 70, 120, 28);
		panelUsuarios.add(btnNewCliente);
		
		btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setBackground(new Color(102, 102, 255));
		btnModificarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnModificarCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModificarCliente.setBounds(1145, 70, 130, 28);
		panelUsuarios.add(btnModificarCliente);
		
		btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.setBackground(new Color(102, 102, 255));
		btnEliminarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarCliente.setBorder(new LineBorder(new Color(102, 102, 255)));
		btnEliminarCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEliminarCliente.setBounds(995, 70, 125, 28);
		panelUsuarios.add(btnEliminarCliente);
		
		panelComponentes = new JPanel();
		panelComponentes.setBounds(247, 0, 1457, 841);
		contentPane.add(panelComponentes);
		panelComponentes.setLayout(null);
		
		panelClientes = new JPanel();
		panelClientes.setBounds(247, 0, 1457, 841);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);
		
		panelFacturas = new JPanel();
		panelFacturas.setBounds(247, 0, 1457, 841);
		contentPane.add(panelFacturas);
		panelFacturas.setLayout(null);
		
		panelAdministracion = new JPanel();
		panelAdministracion.setBounds(247, 0, 1457, 841);
		contentPane.add(panelAdministracion);
		panelAdministracion.setLayout(null);

		
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
		
	}
	
	public static void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		// *** //
	} 
}
