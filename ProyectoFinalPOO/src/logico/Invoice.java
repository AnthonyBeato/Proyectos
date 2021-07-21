package logico;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	
	private String code;						// Identification number.
	private Date date;
	private Seller seller;
	private Customer customer;
	private ArrayList<Component> components;	// List of components sold.
	
	public Invoice(String code, Date date, Seller seller, Customer customer, ArrayList<Component> components) {
		// Constructor with a given list of components.
		super();
		this.code = code;
		this.date = date;
		this.seller = seller;
		this.customer = customer;
		this.components = components;
	}

	public Invoice(String code, Date date, Seller seller, Customer customer) {
		// Constructor without components (to be added separately).
		super();
		this.code = code;
		this.date = date;
		this.seller = seller;
		this.customer = customer;
		this.components = new ArrayList<Component>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}
	
	public void addComponent(Component component) {
		// Adds a component to the list.
		components.add(component);
	}
	
	public float get_total() {
		/* Calculates the total amount to be payed 
		 * for every component. */
		
		float total = 0;
		for (Component component : components) {
			total += component.getPrice();
		}
		return total;
	}

}
