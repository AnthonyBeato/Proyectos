package logico;

public class Cilindrico extends Queso {

	private int longitud;
	private int radioCilindrico;

	public Cilindrico(float precioBase, float precioUnitario, String nombre, int longitud, int radioCilindrico) {
		super(precioBase, precioUnitario, nombre);
		this.longitud = longitud; 
		this.radioCilindrico = radioCilindrico;
	}


	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getRadioCilindrico() {
		return radioCilindrico;
	}

	public void setRadioCilindrico(int radioCilindrico) {
		this.radioCilindrico = radioCilindrico;
	}
	
	public int area() {
		return (int) (Math.PI*Math.pow(radioCilindrico, 2));
	}
	
	public float volumen() {
		
		return (longitud*area());
	}
}
