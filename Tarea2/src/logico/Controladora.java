package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Controladora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Queso> misQuesos;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private static Controladora controladora = null;
	
	private Controladora() {
		this.misQuesos = new ArrayList<Queso>();
		this.misFacturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
	}
	
	public static Controladora getInstance() {
		if (controladora == null) {
			controladora = new Controladora(); 
		}
		return controladora;
	}

	public ArrayList<Queso> getMisQuesos() {
		return misQuesos;
	}

	public void setMisQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public static Controladora getControladora() {
		return controladora;
	}

	public static void setControladora(Controladora controladora) {
		Controladora.controladora = controladora;
	}

	public float precioDelQuesoEsfericoMayor(String idFactura) {
		float precio = 0, mayor = 0;
		for (Queso quesos : misQuesos) {
			if (quesos instanceof Esfera) {
				if (quesos.volumen() > mayor) {
					mayor = quesos.volumen();
					precio = quesos.getPrecioUnitario();  
				}
			}
		}
		
		return precio;
	}

	public void insertarQueso(Queso queso) {
		misQuesos.add(queso);
	}
	
	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
	}
	
	public void crearCliente(Cliente cliente) {
		misClientes.add(cliente);
	}


	public Queso buscarQuesoByID(String idQueso) {
		for (Queso queso : misQuesos) {
			if(queso.getCodigo().equalsIgnoreCase(idQueso)) {
				return queso;
			}
		}
		return null;
	}
	
	/*
	 * 
	public Queso buscarQuesoByNombre(String nombreQueso) {
		for (Queso queso : misQuesos) {
			if(queso.getNombre().equalsIgnoreCase(nombreQueso)) {
				return queso;
			}
		}
		return null;
	}
	
	public int buscarIndexOfQuesoByNombre(String nombre) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado & i < misQuesos.size()) {
			if(misQuesos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}
	 */
	
	public Queso buscarQuesoByNumero(int numQueso) {
		int cantidad = 0;
		for (Queso queso : misQuesos) {
			if(misQuesos.get(numQueso) != null) {
				return queso;
			}
			cantidad++;
		}
		return null;
	}

	public void eliminarQueso(Queso selected) {
		int index = buscarIndexOfQuesoByID(selected.getCodigo()); //aqui
		while(index < misQuesos.size()) {
			misQuesos.remove(index);
			index++;
		}
	}

	public int buscarIndexOfQuesoByID(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado & i < misQuesos.size()) {
			if(misQuesos.get(i).getCodigo().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}

	public void modificarQueso(Queso selected) {
		int aux = buscarIndexOfQuesoByID(selected.getCodigo());
		misQuesos.set(aux, selected);
		
	}

	public int buscarIndexOfClienteByCodigo(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < misClientes.size()) {
			if (misClientes.get(i).getCedula().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public Cliente buscarClienteEspecificoByID(String id) {
		Cliente aux = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < misClientes.size()) {
			if (misClientes.get(i).getCedula().equalsIgnoreCase(id)) {
				aux = misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}



	public void eliminarCliente(Cliente selected) {
		int index = buscarIndexOfClienteByCodigo(selected.getCedula());
		while(index < misClientes.size()) {
			misClientes.remove(index);
			index++;
		}
	}

	public void modificarCliente(Cliente selected) {
		int aux = buscarIndexOfClienteByCodigo(selected.getCedula());
		misClientes.set(aux, selected);
	}
	
	
	
	
}
