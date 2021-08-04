package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Customer;
import logico.Store;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerRegistry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNombres;
	private JSpinner spnCredito;
	private JSpinner spnEdad;
	private Customer selected = null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public CustomerRegistry(Customer customer) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashboardHome.class.getResource("/Img/logo800x800.png")));
		selected = customer;
		if(selected == null) {
			setTitle("Registrar cliente");
		}else {
			setTitle("Modificar cliente");
		}
		setBounds(100, 100, 525, 295);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 479, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(21, 28, 46, 14);
		panel_1.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(44, 24, 160, 23);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y apellido:");
		lblNewLabel_1.setBounds(210, 28, 123, 14);
		panel_1.add(lblNewLabel_1);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(306, 24, 160, 23);
		panel_1.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setBounds(11, 90, 52, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cr\u00E9dito:");
		lblNewLabel_3.setBounds(262, 90, 71, 14);
		panel_1.add(lblNewLabel_3);
		
		spnCredito = new JSpinner();
		spnCredito.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCredito.setBounds(306, 86, 160, 23);
		panel_1.add(spnCredito);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnEdad.setBounds(44, 86, 160, 23);
		panel_1.add(spnEdad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("");
				if(selected == null) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected == null) {
							Customer aux = new Customer(txtID.getText(), txtNombres.getText(), Float.valueOf(spnCredito.getValue().toString()), Integer.valueOf(spnEdad.getValue().toString()));
							Store.getInstance().addCustomer(aux);
							JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente.", "Registro de cliente", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else {
							selected.setId(txtID.getText());
							selected.setName(txtNombres.getText());
							selected.setAge(Integer.valueOf(spnEdad.getValue().toString()));
							selected.setCredit(Float.valueOf(spnCredito.getValue().toString()));
							Store.getInstance().modificarCustomer(selected);
							DashboardHome.load_customers();
							dispose();
						}
					}

				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
		loadCustomers();
	}
	
	private void loadCustomers() {
		if (selected != null) {
			txtID.setText(selected.getId());
			txtNombres.setText(selected.getName());
			spnCredito.setValue(new Float(selected.getCredit()));
			spnEdad.setValue(new Integer(selected.getAge()));
		}
	}

	private void clean() {
		txtID.setText("");
		txtNombres.setText("");
		spnCredito.setValue(0);
		spnEdad.setValue(0);
		
	} 
}
