package logico;

public class CilindricoHueco extends Cilindrico {

	private float radioInterior;
	private int radioCilindricoHueco;	

	public CilindricoHueco(float precioBase, float precioUnitario, String codigo, int longitud, int radioCilindrico,
			float radioInterior, int radioCilindricoHueco) {
		super(precioBase, precioUnitario, codigo, longitud, radioCilindrico);
		this.radioInterior = radioInterior;
		this.radioCilindricoHueco = radioCilindricoHueco;
	} 


	public float getRadioInterior() {
		return radioInterior;
	}



	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}



	public int getRadioCilindricoHueco() {
		return radioCilindricoHueco;
	}



	public void setRadioCilindricoHueco(int radioCilindricoHueco) {
		this.radioCilindricoHueco = radioCilindricoHueco;
	}



	public int area() {
		return (int) (Math.PI*radios());
	}
	
	public float radios() {
		if (radioCilindricoHueco > radioInterior) {
			return (float)((Math.pow(radioCilindricoHueco, 2)) - (Math.pow(radioInterior, 2)));
		}
		
		return 0;
	}
}
