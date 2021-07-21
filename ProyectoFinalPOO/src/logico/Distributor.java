package logico;

import java.util.ArrayList;

public class Distributor {

	private String id;
	private String name;
	private int delivery_time;
	private ArrayList<Component> components;
	public static int counter = 100;
	
	public Distributor(String id, String name, int delivery_time, ArrayList<Component> components) {
		super();
		this.id = id;
		this.name = name;
		this.delivery_time = delivery_time;
		this.components = components;
		counter++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}
	
	
	
}
