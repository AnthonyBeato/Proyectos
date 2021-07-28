package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cilindrico;
import logico.CilindricoHueco;
import logico.Controladora;
import logico.Esfera;
import logico.Queso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnCilndricoHueco;
	private JRadioButton rdbtnCilindrico;
	private JRadioButton rdbtnEsferico;
	private JSpinner spnPrecioBase;
	private JSpinner spnPrecioUnitario;
	private JSpinner spnRadioEsferico;
	private JButton btnRegistrar;
	private JSpinner spnRadioCilindro;
	private JSpinner spnRadioInteriorCIlindricoHueco;
	private JSpinner spnRadioExteriorCilindroHueco;
	private JSpinner spnLongitud;
	private JPanel panelEsferico;
	private JPanel panelCilindro;
	private JPanel panelCilindroHueco;
	private JLabel lblLongitud;
	private JSpinner spnLongitudCilindricoHueco;
	private JLabel lblNewLabel_5;
	private JTextField txtCodigoQueso;
	private Queso selected = null;

	public RegQueso(Queso queso) {
		selected = queso;
		if(selected == null) {
			setTitle("Registrar queso");
		}else {
			setTitle("Modificar queso");
		}
		setBounds(100, 100, 621, 319);
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
			
			JPanel panelRegistro = new JPanel();
			panelRegistro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRegistro.setBounds(10, 11, 581, 74);
			panel.add(panelRegistro);
			panelRegistro.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Precio base:");
			lblNewLabel.setBounds(10, 11, 115, 14);
			panelRegistro.add(lblNewLabel);
			
			spnPrecioBase = new JSpinner();
			spnPrecioBase.setBounds(10, 24, 164, 23);
			panelRegistro.add(spnPrecioBase);
			
			spnPrecioUnitario = new JSpinner();
			spnPrecioUnitario.setBounds(204, 24, 164, 23);
			panelRegistro.add(spnPrecioUnitario);
			
			JLabel lblPrecioUnitario = new JLabel("Precio unitario");
			lblPrecioUnitario.setBounds(204, 11, 115, 14);
			panelRegistro.add(lblPrecioUnitario);
			
			lblNewLabel_5 = new JLabel("C\u00F3digo:");
			lblNewLabel_5.setBounds(407, 10, 164, 14);
			panelRegistro.add(lblNewLabel_5);
			
			txtCodigoQueso = new JTextField();
			txtCodigoQueso.setEnabled(false);
			txtCodigoQueso.setText("Q-"+Queso.codQueso);
			txtCodigoQueso.setBounds(407, 24, 164, 23);
			panelRegistro.add(txtCodigoQueso);
			txtCodigoQueso.setColumns(10);
			
			JPanel panelBotones = new JPanel();
			panelBotones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelBotones.setBounds(10, 96, 581, 39);
			panel.add(panelBotones);
			panelBotones.setLayout(null);
			
			rdbtnEsferico = new JRadioButton("Esf\u00E9rico");
			rdbtnEsferico.setSelected(true);
			rdbtnEsferico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setSelected(true);
					rdbtnCilindrico.setSelected(false);
					rdbtnCilndricoHueco.setSelected(false);
					panelEsferico.setVisible(true);
					panelCilindro.setVisible(false);
					panelCilindroHueco.setVisible(false);
				}
			});
			rdbtnEsferico.setBounds(55, 7, 109, 23);
			panelBotones.add(rdbtnEsferico);
			
			rdbtnCilindrico = new JRadioButton("Cil\u00EDndrico");
			rdbtnCilindrico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setSelected(false);
					rdbtnCilindrico.setSelected(true);
					rdbtnCilndricoHueco.setSelected(false);
					panelEsferico.setVisible(false);
					panelCilindro.setVisible(true);
					panelCilindroHueco.setVisible(false);
				}
			});
			rdbtnCilindrico.setBounds(219, 7, 109, 23);
			panelBotones.add(rdbtnCilindrico);
			
			rdbtnCilndricoHueco = new JRadioButton("Cil\u00EDndrico hueco");
			rdbtnCilndricoHueco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEsferico.setSelected(false);
					rdbtnCilindrico.setSelected(false);
					rdbtnCilndricoHueco.setSelected(true);
					panelEsferico.setVisible(false);
					panelCilindro.setVisible(false);
					panelCilindroHueco.setVisible(true);
				}
			});
			rdbtnCilndricoHueco.setBounds(383, 7, 140, 23);
			panelBotones.add(rdbtnCilndricoHueco);
			
			panelEsferico = new JPanel();
			panelEsferico.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEsferico.setBounds(10, 146, 581, 74);
			panel.add(panelEsferico);
			panelEsferico.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Radio: ");
			lblNewLabel_1.setBounds(10, 11, 67, 14);
			panelEsferico.add(lblNewLabel_1);
			
			spnRadioEsferico = new JSpinner();
			spnRadioEsferico.setBounds(10, 28, 164, 23);
			panelEsferico.add(spnRadioEsferico);
			
			panelCilindro = new JPanel();
			panelCilindro.setVisible(false);
			panelCilindro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCilindro.setBounds(10, 146, 581, 74);
			panel.add(panelCilindro);
			panelCilindro.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Radio:");
			lblNewLabel_2.setBounds(10, 11, 67, 14);
			panelCilindro.add(lblNewLabel_2);
			
			spnRadioCilindro = new JSpinner();
			spnRadioCilindro.setBounds(10, 28, 164, 23);
			panelCilindro.add(spnRadioCilindro);
			
			JLabel label = new JLabel("Longitud:");
			label.setBounds(205, 11, 67, 14);
			panelCilindro.add(label);
			
			spnLongitud = new JSpinner();
			spnLongitud.setBounds(205, 28, 164, 23);
			panelCilindro.add(spnLongitud);
			
			panelCilindroHueco = new JPanel();
			panelCilindroHueco.setVisible(false);
			panelCilindroHueco.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCilindroHueco.setBounds(10, 146, 581, 74);
			panel.add(panelCilindroHueco);
			panelCilindroHueco.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Radio exterior:");
			lblNewLabel_3.setBounds(10, 11, 126, 14);
			panelCilindroHueco.add(lblNewLabel_3);
			
			spnRadioExteriorCilindroHueco = new JSpinner();
			spnRadioExteriorCilindroHueco.setBounds(10, 28, 164, 23);
			panelCilindroHueco.add(spnRadioExteriorCilindroHueco);
			
			JLabel lblNewLabel_4 = new JLabel("Radio interior:");
			lblNewLabel_4.setBounds(204, 11, 164, 14);
			panelCilindroHueco.add(lblNewLabel_4);
			
			spnRadioInteriorCIlindricoHueco = new JSpinner();
			spnRadioInteriorCIlindricoHueco.setBounds(204, 28, 164, 23);
			panelCilindroHueco.add(spnRadioInteriorCIlindricoHueco);
			
			lblLongitud = new JLabel("Longitud:");
			lblLongitud.setBounds(407, 11, 164, 14);
			panelCilindroHueco.add(lblLongitud);
			
			spnLongitudCilindricoHueco = new JSpinner();
			spnLongitudCilindricoHueco.setBounds(407, 28, 164, 23);
			panelCilindroHueco.add(spnLongitudCilindricoHueco); 
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
						if(selected == null) {
							Queso aux = null;
							float precioBase = new Float(spnPrecioBase.getValue().toString());
							float precioUnitario = new Float(spnPrecioUnitario.getValue().toString());
							String codigo = txtCodigoQueso.getText();
							
							if(rdbtnEsferico.isSelected()) {
								int radio = new Integer(spnRadioEsferico.getValue().toString());
								aux = new Esfera(precioBase, precioUnitario, codigo, radio);
							}
							
							if(rdbtnCilindrico.isSelected()) {
								int radio = new Integer(spnRadioCilindro.getValue().toString());
								int longitud = new Integer(spnLongitud.getValue().toString());
								aux = new Cilindrico(precioBase, precioUnitario, codigo, longitud, radio);
							}
							
							if(rdbtnCilndricoHueco.isSelected()) {
								int radioExterior = new Integer(spnRadioExteriorCilindroHueco.getValue().toString());
								float radioInterior = new Float(spnRadioInteriorCIlindricoHueco.getValue().toString());
								int longitud = new Integer(spnLongitudCilindricoHueco.getValue().toString());
								aux = new CilindricoHueco(precioBase, precioUnitario, codigo, longitud, 0, radioInterior, radioExterior);
							}
							Controladora.getInstance().insertarQueso(aux); 
							
							JOptionPane.showMessageDialog(null, "Registrado correctamente", "Registrar queso", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else {
							selected.setCodigo(txtCodigoQueso.getText());
							selected.setPrecioBase(Float.valueOf(spnPrecioBase.getValue().toString()));
							selected.setPrecioUnitario(Float.valueOf(spnPrecioUnitario.getValue().toString()));
							if (selected instanceof Esfera) {
								((Esfera)selected).setRadioEsfera(Integer.valueOf(spnRadioEsferico.getValue().toString()));	
							}
							if(selected instanceof Cilindrico) {
								((Cilindrico)selected).setRadioCilindrico(Integer.valueOf(spnRadioCilindro.getValue().toString()));
								((Cilindrico)selected).setLongitud(Integer.valueOf(spnLongitud.getValue().toString()));	
							}
							if(selected instanceof CilindricoHueco) {
								((CilindricoHueco)selected).setRadioCilindricoHueco(Integer.valueOf(spnRadioExteriorCilindroHueco.getValue().toString()));
								((CilindricoHueco)selected).setRadioInterior(Float.valueOf(spnRadioInteriorCIlindricoHueco.getValue().toString()));
								((CilindricoHueco)selected).setLongitud(Integer.valueOf(spnLongitudCilindricoHueco.getValue().toString()));	
							}
							Controladora.getInstance().modificarQueso(selected);
							ListarQuesos.loadQuesos(0);
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
		loadQueso();
	}
	
	private void loadQueso() {
		if(selected != null) {
			spnPrecioBase.setValue(new Float(selected.getPrecioBase()));
			spnPrecioUnitario.setValue(new Float(selected.getPrecioUnitario()));
			txtCodigoQueso.setText(selected.getCodigo());
			if(selected instanceof Esfera) {
				spnRadioEsferico.setValue(new Integer(((Esfera)selected).getRadioEsfera()).intValue());
			}
			if (selected instanceof Cilindrico && !(selected instanceof CilindricoHueco)) {
				spnRadioCilindro.setValue(new Integer(((Cilindrico)selected).getRadioCilindrico()).intValue());
				spnLongitud.setValue(new Integer(((Cilindrico)selected).getLongitud()).intValue());	
			}
			if(selected instanceof CilindricoHueco && !(selected instanceof Cilindrico)) {
				spnLongitudCilindricoHueco.setValue(new Integer(((CilindricoHueco)selected).getLongitud()).intValue());
				spnRadioExteriorCilindroHueco.setValue(new Integer(((CilindricoHueco)selected).getRadioCilindricoHueco()).intValue());
				spnRadioInteriorCIlindricoHueco.setValue(new Float(((CilindricoHueco)selected).getRadioInterior()));		
			}
		}
		
	}

	private void clean() {
		spnPrecioBase.setValue(0);
		spnPrecioUnitario.setValue(0);
		txtCodigoQueso.setText("Q-"+Queso.codQueso); 
		spnRadioEsferico.setValue(0);
		spnRadioCilindro.setValue(0);
		spnLongitud.setValue(0);
		spnLongitudCilindricoHueco.setValue(0);
		spnRadioExteriorCilindroHueco.setValue(0);
		spnRadioInteriorCIlindricoHueco.setValue(0);		
	}
}
