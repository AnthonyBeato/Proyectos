package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
		
		JLabel lblNewLabel_2 = new JLabel("...");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(46, 410, 154, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("...");
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(46, 372, 154, 27);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("...");
		lblNewLabel_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(46, 334, 154, 27);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("...");
		lblNewLabel_2_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(46, 296, 154, 27);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("...");
		lblNewLabel_2_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(46, 258, 154, 27);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("...");
		lblNewLabel_2_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(46, 220, 154, 27);
		panel.add(lblNewLabel_2_5);
		
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
