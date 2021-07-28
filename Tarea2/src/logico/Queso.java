package logico;

import java.io.Serializable;

public abstract class Queso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float precioBase;
	protected float precioUnitario;
	protected String nombre;
	protected String codigo;
	public static int codQueso = 1;
	

	public Queso(float precioBase, float precioUnitario, String codigo) {
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		this.codigo = codigo;
		Queso.codQueso++;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/*public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}*/

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public abstract float volumen();
	
	public float precioTotal() {
		float precio = 0;
		precio = precioBase + precioUnitario * volumen();
		
		return precio;
	}
	
}
