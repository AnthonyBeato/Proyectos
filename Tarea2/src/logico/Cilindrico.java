package logico;

public class Cilindrico extends Queso {

	private float longitud;
	private float radioCilindrico;

	public Cilindrico(float precioBase, float precioUnitario, String nombre, float longitud, float radioCilindrico) {
		super(precioBase, precioUnitario, nombre);
		this.longitud = longitud; 
		this.radioCilindrico = radioCilindrico;
	}


	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getRadioCilindrico() {
		return radioCilindrico;
	}

	public void setRadioCilindrico(float radioCilindrico) {
		this.radioCilindrico = radioCilindrico;
	}
	
	public float area() {
		return (float) (Math.PI*Math.pow(radioCilindrico, 2));
	} 
	
	public float volumen() {
		
		return (longitud*area());
	}
}
