package logico;

import java.util.ArrayList;

public class Combo {

	private ArrayList<Component> components;
	private float discount;
	
	public Combo(ArrayList<Component> components, float discount) {
		super();
		this.components = components;
		this.discount = discount;
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
