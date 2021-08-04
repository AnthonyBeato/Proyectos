package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;						// Identification number.
	private Date date;
	private User seller;
	private Customer customer;
	private boolean paid;						// This is false if customer paid with credit. Any user may update this attribute.
	private ArrayList<Component> components;	// List of components sold.
	public static int counter = 1000;
	
	public Invoice(String code, Date date, User seller, Customer customer, boolean paid, ArrayList<Component> components) {
		// Constructor with a given list of components.
		super();
		this.code = code;
		this.date = date;
		this.seller = seller;
		this.customer = customer;
		this.paid = paid;
		this.components = components;
		counter++;
	}

	public Invoice(String code, Date date, User seller, Customer customer, boolean paid) {
		// Constructor without components (to be added separately).
		super();
		this.code = code;
		this.date = date;
		this.seller = seller;
		this.customer = customer;
		this.paid = paid;
		this.components = new ArrayList<Component>();
		counter++; 
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

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
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
	
	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public float get_total() {
		/* Calculates the total amount to be paid 
		 * for every component. */
		
		float total = 0;
		for (Component component : components) {
			total += component.getPrice();
		}
		return total;
	}

}
