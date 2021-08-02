package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cilindrico;
import logico.CilindricoHueco;
import logico.Cliente;
import logico.Controladora;
import logico.Esfera;
import logico.Factura;
import logico.Queso;
import logico.Servidor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class RegPedido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JList listVendidos;
	private DefaultListModel<String> listModelVendidos;
	private JList listDisponibles;
	private DefaultListModel<String> listModelDisp;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private Cliente selected = null;

	public RegPedido(Cliente cliente) {
		selected = cliente;
		if(selected == null) {
			setTitle("Registrar pedido");
		}else {
			setTitle("Modificar cliente");
		}
		setBounds(100, 100, 592, 544);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 58, 552, 132);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Nombre:");
					lblNewLabel_1.setBounds(10, 11, 165, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEnabled(false);
					txtNombre.setBounds(10, 27, 248, 23);
					panel_1.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n:");
					lblNewLabel_2.setBounds(10, 71, 215, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setEnabled(false);
					txtDireccion.setBounds(10, 86, 248, 23);
					panel_1.add(txtDireccion);
					txtDireccion.setColumns(10);
				}
				{
					JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
					lblTelfono.setBounds(278, 11, 165, 14);
					panel_1.add(lblTelfono);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setEnabled(false);
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(278, 27, 248, 23);
					panel_1.add(txtTelefono);
				}
			}
			{
				JLabel lblNewLabel = new JLabel("Ingrese cedula del cliente:");
				lblNewLabel.setBounds(10, 11, 248, 14);
				panel.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(10, 27, 248, 23);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(10, 241, 210, 210);
				panel.add(scrollPane);
				
				listDisponibles = new JList();
				listDisponibles.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = listDisponibles.getSelectedIndex();
						if(index != -1) {
							btnDerecha.setEnabled(true);
						}
					}
				});
				listDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listModelDisp = new DefaultListModel<String>();
				listDisponibles.setModel(listModelDisp);
				scrollPane.setViewportView(listDisponibles);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Quesos disponibles:");
				lblNewLabel_3.setBounds(10, 216, 152, 14);
				panel.add(lblNewLabel_3);
			}
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 201, 552, 14);
			panel.add(separator);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(356, 241, 210, 210);
			panel.add(scrollPane);
			
			listVendidos = new JList();
			listVendidos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = listVendidos.getSelectedIndex();
					if(index != -1) {
						btnIzquierda.setEnabled(true);
					}
				}
			});
			listVendidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listModelVendidos = new DefaultListModel<String>();
			listVendidos.setModel(listModelVendidos);
			scrollPane.setViewportView(listVendidos);
			
			JLabel lblQuesosVendidos = new JLabel("Quesos vendidos:");
			lblQuesosVendidos.setBounds(356, 216, 152, 14);
			panel.add(lblQuesosVendidos);
			
			btnDerecha = new JButton(">>");
			btnDerecha.setEnabled(false);
			btnDerecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listDisponibles.getSelectedValue().toString();
					listModelVendidos.addElement(aux);
					listModelDisp.remove(listDisponibles.getSelectedIndex());
					btnDerecha.setEnabled(false);
				}
			});
			btnDerecha.setBounds(244, 301, 89, 23);
			panel.add(btnDerecha);
			
			btnIzquierda = new JButton("<<");
			btnIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listVendidos.getSelectedValue().toString();
					listModelDisp.addElement(aux);
					listModelVendidos.remove(listVendidos.getSelectedIndex());
					btnIzquierda.setEnabled(false);
				}
			});
			if(selected != null) {
				txtCedula.setEnabled(false);
				txtNombre.setEnabled(true);
				txtTelefono.setEnabled(true);
				txtDireccion.setEnabled(true);
				listDisponibles.setEnabled(false);
				listVendidos.setEnabled(false);
			}
			
			btnIzquierda.setEnabled(false);
			btnIzquierda.setBounds(244, 354, 89, 23);
			panel.add(btnIzquierda);
			{
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = Controladora.getInstance().buscarIndexOfClienteByCodigo(txtCedula.getText());;
						if (index == -1){
							clean();
							JOptionPane.showMessageDialog(null, "No se encontró el cliente, registre uno nuevo", "Error", JOptionPane.INFORMATION_MESSAGE);
							txtNombre.setEnabled(true);
							txtDireccion.setEnabled(true);
							txtTelefono.setEnabled(true);
							txtCedula.setText("C-"+Cliente.codCliente);
						}else {
							if (Controladora.getInstance().buscarClienteEspecificoByID(txtCedula.getText()) != null) {
								txtNombre.setText(Controladora.getInstance().buscarClienteEspecificoByID(txtCedula.getText()).getNombre());
								txtDireccion.setText(Controladora.getInstance().buscarClienteEspecificoByID(txtCedula.getText()).getDireccion());
								txtTelefono.setText(Controladora.getInstance().buscarClienteEspecificoByID(txtCedula.getText()).getTelefono());
							}
						}
					}
				});
				btnNewButton.setBounds(268, 27, 89, 23);
				panel.add(btnNewButton);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("");
				if(selected == null) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Esto es para conseguir la fecha actual y convertirla en una String dia-mes-año.
						Date fecha = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						String fecha2 = formatter.format(fecha); 
						File archivo;
						BufferedWriter writer;
						
						String code = "";		// Inicializada aquí arriba para poder ser utilizada en el bloque de creación de archivo.
						Queso quesoAux = null;			// Igual aquí.
						
						if(selected == null) {
							Cliente cliente = new Cliente(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCedula.getText());
							Factura factura = new Factura(cliente);

							if(!listModelVendidos.isEmpty()) {
								for (int i = 0; i < listModelVendidos.getSize(); i++) {
									code = listModelVendidos.getElementAt(i);
									quesoAux = Controladora.getInstance().buscarQuesoByID(code.substring(0, code.indexOf('|')-1));
									factura.insertarQueso(quesoAux);
								}
								
								// Desde aquí creación de archivo.
								String nameSourceFactura = fecha2+".txt";
								archivo = new File("factura/factura.txt");
								float total = 0;
								try {
									writer = new BufferedWriter(new FileWriter(archivo));
									writer.write("Cliente: "+txtNombre.getText());
									writer.newLine();
									writer.newLine(); 
									writer.write("Quesos: ");
									if(!listModelVendidos.isEmpty()) {
										for (int i = 0; i < listModelVendidos.getSize(); i++) {
											code = listModelVendidos.getElementAt(i);
											quesoAux = Controladora.getInstance().buscarQuesoByID(code.substring(0, code.indexOf('|')-1));
											writer.newLine();
											writer.write(code+"\t"+quesoAux.volumen()+"\t"+quesoAux.getPrecioUnitario());
											total += quesoAux.getPrecioUnitario();
										}
									}
									writer.newLine();
									writer.newLine();
									writer.write("Total: "+total);
									writer.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								// Fin de creación de archivo.
								
								// FUNCION DE RESPALDO DE FACTURA
								
								// Controladora.getInstance().FileRespaldo("factura/"+nameSourceFactura, "Respaldo/Respaldo-"+nameSourceFactura);
								/*try {
									Socket sfd = new Socket("127.0.0.1",7000);
								} catch (UnknownHostException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}														*/
								/*String[] args = new String[1];
								args[0] = nameSourceFactura; 
								Servidor.main(args); */
								//Servidor server = new Servidor();
								//  				usar a server aqui.
								
								// FIN DE FUNCION
								
								
								Controladora.getInstance().insertarFactura(factura);
								Controladora.getInstance().crearCliente(cliente);
								System.out.println(factura.getClientes().getNombre()+" "+factura.getMisQuesos().get(0).getCodigo());
								JOptionPane.showMessageDialog(null, "Se ha realizado el pedido", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}else {
								JOptionPane.showMessageDialog(null, "Debe seleccionar como mínimo un queso", "Información", JOptionPane.WARNING_MESSAGE);
							}
						}else {
							selected.setNombre(txtNombre.getText());
							selected.setTelefono(txtTelefono.getText());
							selected.setDireccion(txtDireccion.getText());
							Controladora.getInstance().modificarCliente(selected);
							ListarClientes.loadTable();
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
		loadQuesosDisponibles();
		loadCliente();
	}
	
	private void loadCliente() {
		if(selected != null) {
			txtCedula.setText(selected.getCedula());
			txtNombre.setText(selected.getNombre());
			txtDireccion.setText(selected.getDireccion());
			txtTelefono.setText(selected.getTelefono());			
		}	
	}

	private void loadQuesosDisponibles() {
		listModelDisp.removeAllElements();
		for (int i = 0; i < Controladora.getInstance().getMisQuesos().size(); i++) {
			Queso queso = Controladora.getInstance().getMisQuesos().get(i);
			if(queso instanceof Esfera) {
				String aux = new String(Controladora.getInstance().getMisQuesos().get(i).getCodigo()+" | "+"Esférico");	
				listModelDisp.addElement(aux);
			}
			if(queso instanceof Cilindrico && !(queso instanceof CilindricoHueco)) {
				String aux = new String(Controladora.getInstance().getMisQuesos().get(i).getCodigo()+" | "+"Cilíndrico");	
				listModelDisp.addElement(aux);
			}
			if(queso instanceof CilindricoHueco) {
				String aux = new String(Controladora.getInstance().getMisQuesos().get(i).getCodigo()+" | "+"Cilíndrico hueco");	
				listModelDisp.addElement(aux);
			}
		}
	}

	private void clean() {
		txtCedula.setText(" ");
		txtNombre.setText(" ");
		txtDireccion.setText(" ");
		txtTelefono.setText(" ");	
		listModelVendidos.removeAllElements();
		loadQuesosDisponibles();
	}
}
