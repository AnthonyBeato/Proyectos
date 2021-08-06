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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.channels.SelectableChannel;

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
	private JButton btnBorrar;
	private JList listDisponible;
	private DefaultListModel<String> listModelDrive;
	private logico.Component selected = null;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public ComponentsRegistry(logico.Component component) {
		selected = component;
		if(selected == null) {
			setTitle("Registrar componentes");
		}else {
			setTitle("Modificar componentes");
		}
		setBounds(100, 100, 568, 545);
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
					txtSerial.setText(""+Store.getInstance().autogenerateId());
					txtSerial.setEditable(false);
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
			panelTarjetaMadre.setBounds(10, 277, 524, 175);
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
			int cantRam = RAM.counter;
			int i = 0;
			String[] comboBoxItemsRam = new String[cantRam];
			for (logico.Component componentes : Store.getInstance().getComponents()) {
				if (componentes instanceof RAM) {
					comboBoxItemsRam[i] =  ((RAM) componentes).getType();
					i++;
				}
			}
			cbxRAMCompatibles.setModel(new DefaultComboBoxModel(comboBoxItemsRam));
			cbxRAMCompatibles.setBounds(93, 48, 158, 23);
			panelTarjetaMadre.add(cbxRAMCompatibles);
			
			cbxHDDcompatibles = new JComboBox();
			int cantHDD = Drive.counter;
			int j = 0;
			String[] comboBoxItemsHDD = new String[cantRam];
			for (logico.Component componentes : Store.getInstance().getComponents()) {
				if (componentes instanceof Drive) {
					comboBoxItemsHDD[i] =  ((Drive) componentes).getConnector();
					i++;
				}
			}
			cbxHDDcompatibles.setModel(new DefaultComboBoxModel(comboBoxItemsHDD));
			cbxHDDcompatibles.setBounds(352, 48, 74, 23);
			panelTarjetaMadre.add(cbxHDDcompatibles);
			
			JButton btnAgregar = new JButton("+");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = cbxHDDcompatibles.getSelectedItem().toString();
					listModelDrive.addElement(aux);
				}
			});
			btnAgregar.setBounds(433, 48, 41, 23);
			panelTarjetaMadre.add(btnAgregar);
			
			btnBorrar = new JButton("-");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listModelDrive.remove(listDisponible.getSelectedIndex());
				}
			});
			btnBorrar.setBounds(473, 48, 41, 23);
			panelTarjetaMadre.add(btnBorrar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(352, 82, 162, 82);
			panelTarjetaMadre.add(scrollPane);
			
			listDisponible = new JList();
			listDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = listDisponible.getSelectedIndex();
					if(index != -1) {
						//btnBorrar.setEnabled(false);
					}
				}
			});
			listModelDrive = new DefaultListModel<String>();
			listDisponible.setModel(listModelDrive);
			listDisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listDisponible);
			
			panelCPU = new JPanel();
			panelCPU.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCPU.setVisible(false);
			panelCPU.setBounds(10, 277, 524, 175);
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
			panelRAM.setBounds(10, 277, 524, 175);
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
			panelDRIVE.setBounds(10, 277, 524, 175);
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
				JButton btnRegistrar = new JButton("");
				if(selected == null) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected == null) {
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
								ArrayList<String> hddCompatibles = new ArrayList<String>();
								if(!listModelDrive.isEmpty()) {
									for (int i = 0; i < listModelDrive.getSize(); i++) {
										String drive = listModelDrive.getElementAt(i);							
										hddCompatibles.add(drive); 
										System.out.println("los hdd: "+drive);
									}
								}
								aux = new Motherboard(serial, disponibles, precio, marca, minimo, maximo, model, socket, ramCompatible, hddCompatibles);
							}
							if(rdbtnCpu.isSelected()) {
								String model = txtModelCPU.getText();
								String socket = txtSocketCPU.getText();
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
						}else {
							int index = -1;
							index = Store.getInstance().getComponents().indexOf(selected);
							selected.setSerial(txtSerial.getText());
							selected.setPrice(Float.valueOf(spnPrecio.getValue().toString()));
							selected.setAvailable(Integer.valueOf(spnDisponibles.getValue().toString()));
							selected.setBrand(txtMarca.getText());
							selected.setMin_amount(Integer.valueOf(spnCantMin.getValue().toString()));
							selected.setMax_amount(Integer.valueOf(spnCantMax.getValue().toString()));
							if(selected instanceof Motherboard) {
								((Motherboard) selected).setModel(txtModelTarjeta.getText());
								((Motherboard) selected).setSocket(txtSocketTarjeta.getText());
								((Motherboard) selected).setCompatible_RAM(cbxRAMCompatibles.getSelectedItem().toString());
								/*ArrayList<String> hddSeleccionados = new ArrayList<String>();
								if(!listModelDrive.isEmpty()) {
									for (int i = 0; i < listModelDrive.getSize(); i++) {
										String drive = listModelDrive.getElementAt(i);							
										hddSeleccionados.add(drive); 
										System.out.println("los hdd: "+drive);
									}
								}
								((Motherboard) selected).setCompatible_hdds(hddSeleccionados); */
							}
							if(selected instanceof CPU) {
								((CPU) selected).setModel(txtModelCPU.getText());
								((CPU) selected).setSocket(txtSocketCPU.getText());
								((CPU) selected).setSpeed(Float.valueOf(spnVelocidad.getValue().toString()));
							}
							if(selected instanceof RAM) {
								((RAM) selected).setType(cbxTipo.getSelectedItem().toString());
								((RAM) selected).setCapacity(Float.valueOf(spnCapacidad.getValue().toString()));
							}
							if(selected instanceof Drive) {
								((Drive) selected).setModel(txtModelDrive.getText());
								((Drive) selected).setStorage(Float.valueOf(spnAlmacenamiento.getValue().toString()));
								((Drive) selected).setConnector(cbxConector.getSelectedItem().toString());
							}
							Store.getInstance().mod_components(index, selected);
						}
						DashboardHome.load_components();
						dispose();
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
			
			if(selected != null) {
				if(selected instanceof Motherboard) {
					rdbtnTarjetaMadre.setSelected(true);
					rdbtnCpu.setSelected(false);
					rdbtnRam.setSelected(false);
					rdbtnDrive.setSelected(false);
					panelTarjetaMadre.setVisible(true);
					panelCPU.setVisible(false);
					panelRAM.setVisible(false);
					panelDRIVE.setVisible(false);
				}
				if(selected instanceof CPU) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnCpu.setSelected(true);
					rdbtnRam.setSelected(false);
					rdbtnDrive.setSelected(false);
					panelTarjetaMadre.setVisible(false);
					panelCPU.setVisible(true);
					panelRAM.setVisible(false);
					panelDRIVE.setVisible(false);
				}
				if(selected instanceof RAM) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnCpu.setSelected(false);
					rdbtnRam.setSelected(true);
					rdbtnDrive.setSelected(false);
					panelTarjetaMadre.setVisible(false);
					panelCPU.setVisible(false);
					panelRAM.setVisible(true);
					panelDRIVE.setVisible(false);
				}
				if(selected instanceof Drive) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnCpu.setSelected(false);
					rdbtnRam.setSelected(false);
					rdbtnDrive.setSelected(true);
					panelTarjetaMadre.setVisible(false);
					panelCPU.setVisible(false);
					panelRAM.setVisible(false);
					panelDRIVE.setVisible(true);
				}
				
			}
		}
		loadComponents();
	//	loadDrivesDisponibles();
	}
	private void loadComponents() {
		if(selected != null) {
			txtSerial.setText(selected.getSerial());
			spnPrecio.setValue(new Float(selected.getPrice()));
			spnDisponibles.setValue(new Integer(selected.getAvailable()));
			txtMarca.setText(selected.getBrand());
			spnCantMin.setValue(new Integer(selected.getMin_amount()));
			spnCantMax.setValue(new Integer(selected.getMax_amount()));
			if(selected instanceof Motherboard) {
				txtModelTarjeta.setText(((Motherboard) selected).getModel());
				txtSocketTarjeta.setText(((Motherboard) selected).getSocket());
				cbxRAMCompatibles.setSelectedItem(((Motherboard) selected).getCompatible_RAM());
				cbxHDDcompatibles.setSelectedItem(((Motherboard) selected).getCompatible_hdds());
			}
			if(selected instanceof CPU) {
				txtModelCPU.setText(((CPU) selected).getModel());
				txtSocketCPU.setText(((CPU) selected).getSocket());
				spnVelocidad.setValue(new Float(((CPU) selected).getSpeed()));
			}
			if(selected instanceof RAM) {
				cbxTipo.setSelectedItem(((RAM) selected).getType());
				spnCapacidad.setValue(new Float(((RAM) selected).getCapacity()));
			}
			if(selected instanceof Drive) {
				txtModelDrive.setText(((Drive) selected).getModel());
				spnAlmacenamiento.setValue(new Float(((Drive) selected).getStorage()));
				cbxConector.setSelectedItem(((Drive) selected).getConnector());
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
