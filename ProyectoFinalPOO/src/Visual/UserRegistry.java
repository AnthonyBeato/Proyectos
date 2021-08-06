package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Administrator;
import logico.Seller;
import logico.Store;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserRegistry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_id;
	private JTextField txt_nombre;
	private JTextField txt_username;
	private JTextField txt_password;
	private JRadioButton rdb_vendedor;
	private JPanel pnl_vendedor;
	private JButton btn_registrar;
	private JRadioButton rdb_administrador;
	private JSpinner spn_comision;
	private JPanel pnl_administrador;
	private JSpinner spn_years;
	private User selected = null;

	/**
	 * Create the dialog.
	 */
	public UserRegistry(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardHome.class.getResource("/Img/logo800x800.png")));
		selected = user;
		if(selected == null) {
			setTitle("Registrar Usuario");
		}
		else {
			setTitle("Modificar Usuario");
		}
		setBounds(100, 100, 528, 490);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 13, 476, 194);
			panel.add(panel_1);
			
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(42, 39, 28, 16);
			panel_1.add(lblId);
			
			JLabel lblNewLabel = new JLabel("Nombre de usuario:");
			lblNewLabel.setBounds(98, 94, 116, 16);
			panel_1.add(lblNewLabel);
			
			txt_id = new JTextField();
			txt_id.setText(String.valueOf(Store.getInstance().autogenerateId()));
			txt_id.setEditable(false);
			txt_id.setBounds(66, 36, 116, 22);
			panel_1.add(txt_id);
			txt_id.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre y apellido:");
			lblNewLabel_1.setBounds(211, 39, 116, 16);
			panel_1.add(lblNewLabel_1);
			
			txt_nombre = new JTextField();
			txt_nombre.setBounds(332, 36, 132, 22);
			panel_1.add(txt_nombre);
			txt_nombre.setColumns(10);
			
			txt_username = new JTextField();
			txt_username.setBounds(226, 91, 116, 22);
			panel_1.add(txt_username);
			txt_username.setColumns(10);
			
			txt_password = new JTextField();
			txt_password.setBounds(226, 139, 116, 22);
			panel_1.add(txt_password);
			txt_password.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_2.setBounds(144, 142, 70, 16);
			panel_1.add(lblNewLabel_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(12, 208, 476, 75);
			panel.add(panel_2);
			
			rdb_vendedor = new JRadioButton("Vendedor");
			rdb_vendedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdb_vendedor.setSelected(true);
					rdb_administrador.setSelected(false);
					
					pnl_vendedor.setVisible(true);
					pnl_administrador.setVisible(false);
				}
			});
			rdb_vendedor.setSelected(true);
			rdb_vendedor.setBounds(84, 28, 97, 25);
			panel_2.add(rdb_vendedor);
			
			rdb_administrador = new JRadioButton("Administrador");
			rdb_administrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdb_administrador.setSelected(true);
					rdb_vendedor.setSelected(false);
					
					pnl_administrador.setVisible(true);
					pnl_vendedor.setVisible(false);
				}
			});
			rdb_administrador.setBounds(265, 28, 127, 25);
			panel_2.add(rdb_administrador);
			
			pnl_vendedor = new JPanel();
			pnl_vendedor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnl_vendedor.setBounds(12, 296, 476, 89);
			panel.add(pnl_vendedor);
			pnl_vendedor.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Porcentaje de comisi\u00F3n:");
			lblNewLabel_3.setBounds(129, 34, 146, 16);
			pnl_vendedor.add(lblNewLabel_3);
			
			spn_comision = new JSpinner();
			spn_comision.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spn_comision.setBounds(287, 31, 55, 22);
			pnl_vendedor.add(spn_comision);
			
			pnl_administrador = new JPanel();
			pnl_administrador.setVisible(false);
			pnl_administrador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnl_administrador.setBounds(12, 296, 476, 89);
			panel.add(pnl_administrador);
			pnl_administrador.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("A\u00F1os de experiencia:");
			lblNewLabel_4.setBounds(158, 34, 120, 16);
			pnl_administrador.add(lblNewLabel_4);
			
			spn_years = new JSpinner();
			spn_years.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spn_years.setBounds(290, 31, 52, 22);
			pnl_administrador.add(spn_years);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_registrar = new JButton("Registrar");
				if(selected == null) {
					btn_registrar.setText("Registrar");
				} else {
					btn_registrar.setText("Modificar");
				}
				btn_registrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected == null) {
							User user = null;
							String id = txt_id.getText();
							String username = txt_username.getText();
							String password = txt_password.getText();
							String name = txt_nombre.getText();
							
							if(rdb_vendedor.isSelected()) {
								float commission = Float.valueOf(spn_comision.getValue().toString());
								user = new Seller(id, username, password, name, 0, commission);
							}
							
							else if(rdb_administrador.isSelected()) {
								int years = Integer.valueOf(spn_years.getValue().toString());
								user = new Administrator(id, username, password, name, years);
							}
							
							Store.getInstance().addUser(user);
							JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente.", "Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						else {
							int index = -1;
							index = Store.getInstance().getUsers().indexOf(selected);
							selected.setId(txt_id.getText());
							selected.setUsername(txt_username.getText());
							selected.setPassword(txt_password.getText());
							selected.setName(txt_nombre.getText());
							
							if(selected instanceof Seller) {
								((Seller) selected).setCommission(Float.valueOf(spn_comision.getValue().toString()));
							}
							
							else if(selected instanceof Administrator) {
								((Administrator) selected).setYears(Integer.valueOf(spn_years.getValue().toString()));
							}
							Store.getInstance().modifyUser(index, selected);
						}
						DashboardHome.load_users();
						dispose();
					} 
				});
				btn_registrar.setActionCommand("OK");
				buttonPane.add(btn_registrar);
				getRootPane().setDefaultButton(btn_registrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		load_user();
	}
	
	private void load_user() {
		if(selected != null) {
			txt_id.setText(selected.getId());
			txt_username.setText(selected.getUsername());
			txt_password.setText(selected.getPassword());
			txt_nombre.setText(selected.getName());
			if(selected instanceof Seller) {
				spn_comision.setValue(((Seller) selected).getCommission());
			}
			else if(selected instanceof Administrator) {
				spn_years.setValue(((Administrator) selected).getYears());
			}
		}
	}

	private void clean() {
		txt_id.setText(""+User.counter);
		txt_username.setText("");
		txt_password.setText("");
		txt_nombre.setText("");
		spn_comision.setValue(0);
		spn_years.setValue(0);
		
	} 
}
