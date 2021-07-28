package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente clientes;
	private ArrayList<Queso> misQuesos;
	static int codFactura;
	
	public Factura(Cliente clientes) {
		super();
		this.clientes = clientes;
		this.misQuesos = new ArrayList<Queso>();
		Factura.codFactura++;
	}
	
	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Queso> getMisQuesos() {
		return misQuesos;
	}

	public void setMisQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}
	
	public void insertarQueso(Queso queso) {
		misQuesos.add(queso);
	}

	public float precioFactura() {
		int precio = 0;
		for (Queso queso : misQuesos) {
			precio += queso.getPrecioUnitario();
		}
		return precio; 
	}
	
}
