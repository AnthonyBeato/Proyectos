package logico;

import java.io.Serializable;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;			// Identity card number
	private String name;		// Name and surname
	private float credit;		// Arbitrarily set by user who creates Customer.
	private int age;			//Customer's age
	
	
	public Customer(String id, String name, float credit, int age) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.age = age;
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
	
	public float getCredit() {
		return credit;
	}
	
	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age; 
	}

}