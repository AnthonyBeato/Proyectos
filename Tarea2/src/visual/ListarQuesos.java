package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cilindrico;
import logico.CilindricoHueco;
import logico.Controladora;
import logico.Esfera;
import logico.Queso;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarQuesos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private static JButton btnEliminar;
	private static JButton btnModificar;
	JComboBox cbxTipoQueso;
	private Queso selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarQuesos dialog = new ListarQuesos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarQuesos() {
		setTitle("Listado de quesos");
		setBounds(100, 100, 809, 525);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tipo de quesos:");
			lblNewLabel.setBounds(10, 11, 180, 14);
			panel.add(lblNewLabel);
			
			cbxTipoQueso = new JComboBox();
			cbxTipoQueso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selection = cbxTipoQueso.getSelectedIndex();
					loadQuesos(selection);
				}
			});
			cbxTipoQueso.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Esf\u00E9rico", "Cil\u00EDndrico", "Cil\u00EDndrico hueco"}));
			cbxTipoQueso.setBounds(10, 29, 149, 20);
			panel.add(cbxTipoQueso);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 60, 769, 358);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			String headers[] = {"Código","Precio base","Precio unitario","Radio exterior","Radio interior","Longitud","Tipo de queso"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			loadQuesos(0);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = table.getSelectedRow();
					if(index != -1) {
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						String id = (String)(model.getValueAt(index, 0));
						selected = Controladora.getInstance().buscarQuesoByID(id);
						System.out.println(selected.getCodigo()+" "+selected.getPrecioBase());
					}
				}
			});
			table.setModel(model);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegQueso aux = new RegQueso(selected);
					aux.setModal(true);
					aux.setVisible(true);
				}
			});
			btnModificar.setEnabled(false);
			buttonPane.add(btnModificar);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el queso seleccionado: "+selected.getCodigo(), "Eliminar queso", JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
							Controladora.getInstance().eliminarQueso(selected);
							int selection = cbxTipoQueso.getSelectedIndex();
							loadQuesos(selection); 
						}
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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

	public static void loadQuesos(int selection) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		switch(selection) {
		case 0:
			for (Queso aux: Controladora.getInstance().getMisQuesos()) {
				rows[0] = aux.getCodigo();
				rows[1] = aux.getPrecioBase();
				rows[2] = aux.getPrecioUnitario();
				rows[3] = "-";
				rows[4] = "-";
				rows[5] = "-";
				if (aux instanceof Esfera)
					rows[6] = "Esféra";
				if (aux instanceof Cilindrico)
					rows[6] = "Cilíndrico";
				if (aux instanceof CilindricoHueco)
					rows[6] = "Cilíndrico hueco";
				
				model.addRow(rows);
			}
			break;
		
		case 1:
			for(Queso aux :Controladora.getInstance().getMisQuesos()){
				if (aux instanceof Esfera) {
					rows[0] = aux.getCodigo();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = ((Esfera)aux).getRadioEsfera();
					rows[4] = "N/A";
					rows[5] = "N/A";
					rows[6] = "Esférico";
					
					model.addRow(rows);
				}
			}
			break;
			
		case 2:
			for(Queso aux : Controladora.getInstance().getMisQuesos()) {
				if (aux instanceof Cilindrico && !(aux instanceof CilindricoHueco)) {
					rows[0] = aux.getCodigo();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = ((Cilindrico)aux).getRadioCilindrico();
					rows[4] = "N/A";
					rows[5] = ((Cilindrico)aux).getLongitud();
					rows[6] = "Cilíndrico";
					
					model.addRow(rows);
				}
			}
			break;
			
		case 3:
			for(Queso aux : Controladora.getInstance().getMisQuesos()) {
				if (aux instanceof CilindricoHueco) {
					rows[0] = aux.getCodigo();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = ((CilindricoHueco)aux).getRadioCilindricoHueco();
					rows[4] = ((CilindricoHueco)aux).getRadioInterior();
					rows[5] = ((CilindricoHueco)aux).getLongitud();
					rows[6] = "Cilíndrico hueco";		
					
					model.addRow(rows);
				}
			}
			break;
		}
		//btnEliminar.setEnabled(false);
		//btnModificar.setEnabled(false);
	}

		
}

