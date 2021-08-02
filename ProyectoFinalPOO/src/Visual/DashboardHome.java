package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import logico.Store;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class DashboardHome extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardHome frame = new DashboardHome();
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
				} catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width-200, dim.height-200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 248, 841);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cerrar Sesi\u00F3n");
		lblNewLabel_1.setForeground(new Color(255, 0, 51));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del Sistema?",
		                "Confirmaci\u00F3n", JOptionPane.YES_NO_OPTION,
		                JOptionPane.WARNING_MESSAGE);
				if(opc == 0) {
					FileOutputStream enterprise2;
					ObjectOutputStream enterpriseWrite;
					try {
						enterprise2 = new FileOutputStream("enterprise.dat");
						enterpriseWrite = new ObjectOutputStream(enterprise2);
						enterpriseWrite.writeObject(Store.getInstance());
					} catch(FileNotFoundException e1) {
						e1.printStackTrace();
					}catch(IOException e1) {
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
		lblNewLabel_1.setBounds(46, 755, 154, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Administraci\u00F3n");
		lblNewLabel_2.setForeground(new Color(102, 102, 255));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(46, 440, 154, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Facturas");
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(46, 402, 154, 27);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Clientes");
		lblNewLabel_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(46, 364, 154, 27);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Componentes");
		lblNewLabel_2_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(46, 326, 154, 27);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Usuarios");
		lblNewLabel_2_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(46, 288, 154, 27);
		panel.add(lblNewLabel_2_4);
		
		JLabel MenuOPC = new JLabel("Men\u00FA");
		MenuOPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuOPC.setHorizontalAlignment(SwingConstants.CENTER);
		MenuOPC.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		MenuOPC.setBounds(46, 250, 154, 27);
		panel.add(MenuOPC);
		
		JLabel lblNewLabel_4 = new JLabel("TechShop");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(102, 102, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(64, 11, 168, 50);
		panel.add(lblNewLabel_4);
		
		JLabel IconoLabel = new JLabel("");
		IconoLabel.setBounds(46, 11, 50, 50);
		
		ImageIcon ico = new ImageIcon(getClass().getResource("/Img/logo800x800.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(IconoLabel.getWidth(), IconoLabel.getHeight(), Image.SCALE_SMOOTH));
		IconoLabel.setIcon(img);
	
		panel.add(IconoLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(247, 0, 1457, 841);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(211, 211, 211));
		separator.setBounds(0, 40, 1457, 11);
		panel_1.add(separator);
		
		JLabel lblNewLabel = new JLabel("MEN\u00DA");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 87, 40);
		panel_1.add(lblNewLabel);
		
		final JLabel etiquetaReloj = new JLabel("...");
		etiquetaReloj.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaReloj.setBounds(1207, 0, 240, 40);
		panel_1.add(etiquetaReloj);
		
		JLabel lblVistaGeneral = new JLabel("Vista General");
		lblVistaGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblVistaGeneral.setBounds(23, 74, 158, 40);
		panel_1.add(lblVistaGeneral);
		
		JPanel panelClienteSuperior = new JPanel();
		panelClienteSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelClienteSuperior.setBackground(new Color(30, 144, 255));
		panelClienteSuperior.setBounds(52, 125, 272, 57);
		panel_1.add(panelClienteSuperior);
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
		panel_1.add(panelClienteDatos);
		panelClienteDatos.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("22");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(152, 0, 90, 51);
		panelClienteDatos.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Atendidos");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(152, 27, 110, 40);
		panelClienteDatos.add(lblNewLabel_3_1);
		
		JPanel panelComponentesSuperior = new JPanel();
		panelComponentesSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelComponentesSuperior.setBackground(new Color(102, 102, 255));
		panelComponentesSuperior.setBounds(416, 125, 272, 57);
		panel_1.add(panelComponentesSuperior);
		panelComponentesSuperior.setLayout(null);
		
		JLabel lblVistaGeneral_1_1 = new JLabel("Componentes");
		lblVistaGeneral_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaGeneral_1_1.setForeground(Color.WHITE);
		lblVistaGeneral_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblVistaGeneral_1_1.setBounds(10, 11, 252, 35);
		panelComponentesSuperior.add(lblVistaGeneral_1_1);
		
		JPanel panelComponentesDatos = new JPanel();
		panelComponentesDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelComponentesDatos.setBackground(Color.WHITE);
		panelComponentesDatos.setBounds(416, 182, 272, 89);
		panel_1.add(panelComponentesDatos);
		panelComponentesDatos.setLayout(null);
		
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
		panelUsuariosSuperior.setBackground(new Color(255, 0, 51));
		panelUsuariosSuperior.setBounds(782, 125, 272, 57);
		panel_1.add(panelUsuariosSuperior);
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
		panel_1.add(panelUsuariosDatos);
		panelUsuariosDatos.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("3");
		lblNewLabel_3_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(152, 0, 90, 51);
		panelUsuariosDatos.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Registrados");
		lblNewLabel_3_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_2.setBounds(152, 27, 110, 40);
		panelUsuariosDatos.add(lblNewLabel_3_1_2);
		
		JPanel panelFacturasSuperior = new JPanel();
		panelFacturasSuperior.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFacturasSuperior.setBackground(new Color(51, 204, 102));
		panelFacturasSuperior.setBounds(1136, 125, 272, 57);
		panel_1.add(panelFacturasSuperior);
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
		panel_1.add(panelFacturaDatos);
		panelFacturaDatos.setLayout(null);
		
		JLabel lblNewLabel_3_4 = new JLabel("22");
		lblNewLabel_3_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_4.setBounds(152, 0, 90, 51);
		panelFacturaDatos.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Generadas");
		lblNewLabel_3_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewLabel_3_1_3.setBounds(152, 27, 110, 40);
		panelFacturaDatos.add(lblNewLabel_3_1_3);
		
		
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
}
