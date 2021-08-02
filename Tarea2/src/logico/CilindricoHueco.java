package logico;

public class CilindricoHueco extends Cilindrico {

	private float radioInterior;
	private float radioCilindricoHueco;	

	public CilindricoHueco(float precioBase, float precioUnitario, String codigo, float longitud, float radioCilindrico,
			float radioInterior, float radioCilindricoHueco) {
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



	public float getRadioCilindricoHueco() {
		return radioCilindricoHueco;
	}



	public void setRadioCilindricoHueco(float radioCilindricoHueco) {
		this.radioCilindricoHueco = radioCilindricoHueco;
	}

	public float radios() {
		if (radioCilindricoHueco > radioInterior) {
			return (float)((Math.pow(radioCilindricoHueco, 2)) - (Math.pow(radioInterior, 2)));
		}
		
		return 0;
	}

	public float area() { 
		return (float) (Math.PI*radios());
	}
  
} 
