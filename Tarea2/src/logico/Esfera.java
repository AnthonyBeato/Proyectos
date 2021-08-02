package logico;

public class Esfera extends Queso {

	private float radioEsfera;	
	

	public Esfera(float precioBase, float precioUnitario, String codigo, float radioEsfera) {
		super(precioBase, precioUnitario, codigo);
		this.radioEsfera = radioEsfera;
	} 


	public float getRadioEsfera() {
		return radioEsfera;
	}



	public void setRadioEsfera(float radioEsfera) {
		this.radioEsfera = radioEsfera;
	}



	public float volumen() {
		float vol = (float )(4/3 * Math.PI * Math.pow(radioEsfera, 3)); 
		System.out.println(""+radioEsfera);
		System.out.println("El valor es "+vol); 
		return vol;
	}
 
}
