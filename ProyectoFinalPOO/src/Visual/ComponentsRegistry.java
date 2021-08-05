package Visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.CPU;
import logico.Drive;
import logico.Motherboard;
import logico.RAM;
import logico.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ComponentsRegistry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerial;
	private JTextField txtMarca;
	private JSpinner spnCantMin;
	private JSpinner spnCantMax;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnRam;
	private JRadioButton rdbtnCpu;
	private JRadioButton rdbtnDrive;
	private JTextField txtModelTarjeta;
	private JTextField txtSocketTarjeta;
	private JComboBox cbxRAMCompatibles;
	private JTextField txtModelCPU;
	private JTextField txtSocketCPU;
	private JTextField txtModelDrive;
	private JSpinner spnDisponibles;
	private JSpinner spnPrecio;
	private JComboBox cbxHDDcompatibles;
	private JComboBox cbxTipo;
	private JSpinner spnCapacidad;
	private JComboBox cbxConector;
	private JSpinner spnAlmacenamiento;
	private JSpinner spnVelocidad;
	private JPanel panelTarjetaMadre;
	private JPanel panelCPU;
	private JPanel panelRAM;
	private JPanel panelDRIVE;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public ComponentsRegistry(logico.Component selected_components) {
		setTitle("Registrar componentes");
		setBounds(100, 100, 568, 465);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 11, 524, 179);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Serial:");
					lblNewLabel.setBounds(10, 27, 123, 14);
					panel_1.add(lblNewLabel);
				}
				{
					txtSerial = new JTextField();
					txtSerial.setBounds(55, 23, 167, 23);
					panel_1.add(txtSerial);
					txtSerial.setColumns(10);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Disponibles:");
					lblNewLabel_1.setBounds(266, 27, 99, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					spnDisponibles = new JSpinner();
					spnDisponibles.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnDisponibles.setBounds(335, 23, 167, 23);
					panel_1.add(spnDisponibles);
				}
				{
					JLabel lblPrecio = new JLabel("Precio:");
					lblPrecio.setBounds(10, 61, 99, 14);
					panel_1.add(lblPrecio);
				}
				{
					spnPrecio = new JSpinner();
					spnPrecio.setBounds(55, 57, 167, 23);
					panel_1.add(spnPrecio);
				}
				{
					JLabel lblMarca = new JLabel("Marca:");
					lblMarca.setBounds(292, 61, 123, 14);
					panel_1.add(lblMarca);
				}
				{
					txtMarca = new JTextField();
					txtMarca.setColumns(10);
					txtMarca.setBounds(335, 57, 167, 23);
					panel_1.add(txtMarca);
				}
				{
					JLabel lblCantidadMnima = new JLabel("Cantidad m\u00EDnima:");
					lblCantidadMnima.setBounds(107, 98, 99, 14);
					panel_1.add(lblCantidadMnima);
				}
				{
					spnCantMin = new JSpinner();
					spnCantMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnCantMin.setBounds(198, 94, 167, 23);
					panel_1.add(spnCantMin);
				}
				{
					JLabel lblCantidadMxima = new JLabel("Cantidad m\u00E1xima:");
					lblCantidadMxima.setBounds(107, 134, 99, 14);
					panel_1.add(lblCantidadMxima);
				}
				{
					spnCantMax = new JSpinner();
					spnCantMax.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
					spnCantMax.setBounds(198, 130, 167, 23);
					panel_1.add(spnCantMax);
				}
			}
			{
				JPanel panelOpciones = new JPanel();
				panelOpciones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelOpciones.setBounds(10, 201, 524, 65);
				panel.add(panelOpciones);
				panelOpciones.setLayout(null);
				
				rdbtnTarjetaMadre = new JRadioButton("Tarjeta madre");
				rdbtnTarjetaMadre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnTarjetaMadre.setSelected(true);
						rdbtnCpu.setSelected(false);
						rdbtnRam.setSelected(false);
						rdbtnDrive.setSelected(false);
						panelTarjetaMadre.setVisible(true);
						panelCPU.setVisible(false);
						panelRAM.setVisible(false);
						panelDRIVE.setVisible(false);
					}
				});
				rdbtnTarjetaMadre.setSelected(true);
				rdbtnTarjetaMadre.setBounds(35, 19, 117, 23);
				panelOpciones.add(rdbtnTarjetaMadre);
				
				rdbtnCpu = new JRadioButton("CPU");
				rdbtnCpu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnTarjetaMadre.setSelected(false);
						rdbtnCpu.setSelected(true);
						rdbtnRam.setSelected(false);
						rdbtnDrive.setSelected(false);
						panelTarjetaMadre.setVisible(false);
						panelCPU.setVisible(true);
						panelRAM.setVisible(false);
						panelDRIVE.setVisible(false);
					}
				});
				rdbtnCpu.setBounds(187, 19, 62, 23);
				panelOpciones.add(rdbtnCpu);
				
				rdbtnRam = new JRadioButton("RAM");
				rdbtnRam.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnTarjetaMadre.setSelected(false);
						rdbtnCpu.setSelected(false);
						rdbtnRam.setSelected(true);
						rdbtnDrive.setSelected(false);
						panelTarjetaMadre.setVisible(false);
						panelCPU.setVisible(false);
						panelRAM.setVisible(true);
						panelDRIVE.setVisible(false);
					}
				});
				rdbtnRam.setBounds(284, 19, 85, 23);
				panelOpciones.add(rdbtnRam);
				
				rdbtnDrive = new JRadioButton("Drive");
				rdbtnDrive.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnTarjetaMadre.setSelected(false);
						rdbtnCpu.setSelected(false);
						rdbtnRam.setSelected(false);
						rdbtnDrive.setSelected(true);
						panelTarjetaMadre.setVisible(false);
						panelCPU.setVisible(false);
						panelRAM.setVisible(false);
						panelDRIVE.setVisible(true);
					}
				});
				rdbtnDrive.setBounds(404, 19, 85, 23);
				panelOpciones.add(rdbtnDrive);
			}
			
			panelTarjetaMadre = new JPanel();
			panelTarjetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTarjetaMadre.setBounds(10, 277, 524, 92);
			panel.add(panelTarjetaMadre);
			panelTarjetaMadre.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Model:");
			lblNewLabel_2.setBounds(51, 15, 68, 14);
			panelTarjetaMadre.add(lblNewLabel_2);
			
			txtModelTarjeta = new JTextField();
			txtModelTarjeta.setColumns(10);
			txtModelTarjeta.setBounds(93, 11, 158, 23);
			panelTarjetaMadre.add(txtModelTarjeta);
			
			JLabel lblSocket = new JLabel("Socket:");
			lblSocket.setBounds(312, 15, 68, 14);
			panelTarjetaMadre.add(lblSocket);
			
			txtSocketTarjeta = new JTextField();
			txtSocketTarjeta.setColumns(10);
			txtSocketTarjeta.setBounds(352, 11, 158, 23);
			panelTarjetaMadre.add(txtSocketTarjeta);
			{
				JLabel lblRamCompatible = new JLabel("Ram compatible:");
				lblRamCompatible.setBounds(10, 52, 109, 14);
				panelTarjetaMadre.add(lblRamCompatible);
			}
			{
				JLabel lblHddsCompatible = new JLabel("HDD's compatible:");
				lblHddsCompatible.setBounds(261, 52, 109, 14);
				panelTarjetaMadre.add(lblHddsCompatible);
			}
			
			cbxRAMCompatibles = new JComboBox();
			cbxRAMCompatibles.setBounds(93, 48, 158, 23);
			panelTarjetaMadre.add(cbxRAMCompatibles);
			
			cbxHDDcompatibles = new JComboBox();
			cbxHDDcompatibles.setBounds(352, 48, 158, 23);
			panelTarjetaMadre.add(cbxHDDcompatibles);
			
			panelCPU = new JPanel();
			panelCPU.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCPU.setVisible(false);
			panelCPU.setBounds(10, 277, 524, 92);
			panel.add(panelCPU);
			panelCPU.setLayout(null);
			{
				JLabel label = new JLabel("Model:");
				label.setBounds(51, 15, 68, 14);
				panelCPU.add(label);
			}
			{
				txtModelCPU = new JTextField();
				txtModelCPU.setColumns(10);
				txtModelCPU.setBounds(93, 11, 158, 23);
				panelCPU.add(txtModelCPU);
			}
			{
				JLabel label = new JLabel("Socket:");
				label.setBounds(312, 15, 68, 14);
				panelCPU.add(label);
			}
			{
				txtSocketCPU = new JTextField();
				txtSocketCPU.setColumns(10);
				txtSocketCPU.setBounds(352, 11, 158, 23);
				panelCPU.add(txtSocketCPU);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Velocidad: (GHz)");
				lblNewLabel_3.setBounds(10, 52, 109, 14);
				panelCPU.add(lblNewLabel_3);
			}
			{
				spnVelocidad = new JSpinner();
				spnVelocidad.setBounds(93, 48, 158, 23);
				panelCPU.add(spnVelocidad);
			}
			
			panelRAM = new JPanel();
			panelRAM.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRAM.setVisible(false);
			panelRAM.setBounds(10, 277, 524, 92);
			panel.add(panelRAM);
			panelRAM.setLayout(null);
			{
				JLabel lblNewLabel_4 = new JLabel("Tipo:");
				lblNewLabel_4.setBounds(51, 15, 68, 14);
				panelRAM.add(lblNewLabel_4);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR-2", "DDR-3"}));
				cbxTipo.setBounds(93, 11, 158, 23);
				panelRAM.add(cbxTipo);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Capacidad: (GB)");
				lblNewLabel_5.setBounds(312, 11, 158, 23);
				panelRAM.add(lblNewLabel_5);
			}
			{
				spnCapacidad = new JSpinner();
				spnCapacidad.setBounds(352, 11, 158, 23);
				panelRAM.add(spnCapacidad);
			}
			
			panelDRIVE = new JPanel();
			panelDRIVE.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDRIVE.setVisible(false);
			panelDRIVE.setBounds(10, 277, 524, 92);
			panel.add(panelDRIVE);
			panelDRIVE.setLayout(null);
			{
				JLabel label = new JLabel("Model:");
				label.setBounds(51, 15, 68, 14);
				panelDRIVE.add(label);
			}
			{
				txtModelDrive = new JTextField();
				txtModelDrive.setColumns(10);
				txtModelDrive.setBounds(93, 11, 158, 23);
				panelDRIVE.add(txtModelDrive);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Conector:");
				lblNewLabel_6.setBounds(312, 15, 68, 14);
				panelDRIVE.add(lblNewLabel_6);
			}
			{
				cbxConector = new JComboBox();
				cbxConector.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "IDE", "SATA", "SATA-2", "SATA-3"}));
				cbxConector.setBounds(352, 11, 158, 23);
				panelDRIVE.add(cbxConector);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Almacenamiento: (GB)");
				lblNewLabel_7.setBounds(10, 52, 109, 14);
				panelDRIVE.add(lblNewLabel_7);
			}
			{
				spnAlmacenamiento = new JSpinner();
				spnAlmacenamiento.setBounds(93, 48, 158, 23);
				panelDRIVE.add(spnAlmacenamiento);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logico.Component aux = null;
						String serial = txtSerial.getText();
						int disponibles = new Integer(spnDisponibles.getValue().toString());
						float precio = new Float(spnPrecio.getValue().toString());
						String marca = txtMarca.getText();
						int minimo = new Integer(spnCantMin.getValue().toString());
						int maximo = new Integer(spnCantMax.getValue().toString());
						
						if (rdbtnTarjetaMadre.isSelected()) {
							String model = txtModelTarjeta.getText();
							String socket = txtSocketTarjeta.getText();
							String ramCompatible = cbxRAMCompatibles.getSelectedItem().toString();
							String hddCompatible = cbxHDDcompatibles.getSelectedItem().toString();
							//aux = new Motherboard(serial, disponibles, precio, marca, minimo, maximo, model, socket, ramCompatible, hddCompatible);
						}
						if(rdbtnCpu.isSelected()) {
							String model = txtModelTarjeta.getText();
							String socket = txtSocketTarjeta.getText();
							float speed = new Float(spnVelocidad.getValue().toString());
							aux = new CPU(serial, disponibles, precio, marca, minimo, maximo, model, socket, speed);
						}
						if(rdbtnRam.isSelected()) {
							String tipo = cbxTipo.getSelectedItem().toString();
							float capacidad = new Float(spnCapacidad.getValue().toString());
							aux = new RAM(serial, disponibles, precio, marca, minimo, maximo, tipo, capacidad);
						}
						if(rdbtnDrive.isSelected()) {
							String model = txtModelDrive.getText();
							String conector = cbxConector.getSelectedItem().toString();
							float almacenamiento = new Float(spnAlmacenamiento.getValue().toString());
							aux = new Drive(serial, disponibles, precio, marca, minimo, maximo, model, conector, almacenamiento);
						}
						Store.getInstance().addComponent(aux);
						JOptionPane.showMessageDialog(null, "Componente registrado satisfactoriamente.", "Registro de componente", JOptionPane.INFORMATION_MESSAGE);
						clean();
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
	}
	
	private void clean() {
		txtSerial.setText("");
		spnPrecio.setValue(0);
		spnDisponibles.setValue(0);
		txtMarca.setText("");
		spnCantMin.setValue(0);
		spnCantMax.setValue(0);
		txtModelTarjeta.setText("");
		txtModelCPU.setText("");
		txtModelDrive.setText("");
		txtSocketCPU.setText("");
		txtSocketTarjeta.setText("");
		cbxRAMCompatibles.setSelectedItem(0);
		cbxHDDcompatibles.setSelectedItem(0);
		spnVelocidad.setValue(0);
		cbxTipo.setSelectedItem(0);
		spnCapacidad.setValue(0);
		spnAlmacenamiento.setValue(0);
		cbxConector.setSelectedItem(0);
		
	} 
}
