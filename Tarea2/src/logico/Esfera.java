package logico;

public class Esfera extends Queso {

	private int radioEsfera;	
	

	public Esfera(float precioBase, float precioUnitario, String codigo, int radioEsfera) {
		super(precioBase, precioUnitario, codigo);
		this.radioEsfera = radioEsfera;
	} 


	public int getRadioEsfera() {
		return radioEsfera;
	}



	public void setRadioEsfera(int radioEsfera) {
		this.radioEsfera = radioEsfera;
	}



	public float volumen() {
		return (float) ((4/3) * Math.PI * Math.pow(radioEsfera, 3)); 
	}

}
