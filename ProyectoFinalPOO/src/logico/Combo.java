package logico;

import java.util.ArrayList;

public class Combo {
	
	private String code;
	private ArrayList<Component> components;
	private float discount;
	public static int counter = 100;
	
	public Combo(String code, ArrayList<Component> components, float discount) {
		super();
		this.code = code;
		this.components = components;
		this.discount = discount;
		counter++;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
	
}
