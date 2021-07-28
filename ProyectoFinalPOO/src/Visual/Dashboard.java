package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Store;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(102, 102, 255));
		panelLateral.setBounds(-16, -11, 255, 842);
		panel.add(panelLateral);
		panelLateral.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 145, 56, 24);
		panelLateral.add(lblNewLabel);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(Color.WHITE);
		lblEmpleados.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblEmpleados.setBounds(37, 180, 99, 24);
		panelLateral.add(lblEmpleados);
		
		JLabel lblCerrarSesion = new JLabel("Cerrar Sesion");
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login aux = new Login();
				aux.setUndecorated(true);
				aux.setVisible(true);
			}
		});
		lblCerrarSesion.setForeground(Color.WHITE);
		lblCerrarSesion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblCerrarSesion.setBounds(37, 779, 147, 24);
		panelLateral.add(lblCerrarSesion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(237, 0, 1457, 831);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 11, 136, 29);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 51, 1457, 2);
		panel_1.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(26, 94, 391, 170);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(520, 94, 391, 170);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(1010, 94, 391, 170);
		panel_1.add(panel_4);
	}
}
