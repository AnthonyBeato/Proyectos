package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Store;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FacturarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbx_cliente;
	private JRadioButton rdb_credito;
	private JButton btn_facturar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturarCombo dialog = new FacturarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FacturarCombo() {
		setTitle("Facturar combo");
		setBounds(100, 100, 450, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cliente:");
			lblNewLabel.setBounds(63, 51, 56, 16);
			panel.add(lblNewLabel);
			
			String[] comboBoxItems = new String[Store.getInstance().getCustomers().size()+1];
			comboBoxItems[0] = "<Seleccionar>";
			for (int i = 1; i < Store.getInstance().getCustomers().size()+1; i++) {
				comboBoxItems[i] = Store.getInstance().getCustomers().get(i).getId() + " " + Store.getInstance().getCustomers().get(i).getName();
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
			cbx_cliente = new JComboBox(model);
			cbx_cliente.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						if(cbx_cliente.getSelectedIndex() != 0) {
							rdb_credito.setEnabled(true);
						}
						else {
							rdb_credito.setEnabled(false);
						}
					}
				}
			});
			cbx_cliente.setBounds(131, 48, 220, 22);
			panel.add(cbx_cliente);
			
			rdb_credito = new JRadioButton("Compra a cr\u00E9dito");
			rdb_credito.setEnabled(false);
			rdb_credito.setBounds(131, 94, 127, 25);
			panel.add(rdb_credito);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_facturar = new JButton("Facturar");
				btn_facturar.setActionCommand("OK");
				buttonPane.add(btn_facturar);
				getRootPane().setDefaultButton(btn_facturar);
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
	}
}
