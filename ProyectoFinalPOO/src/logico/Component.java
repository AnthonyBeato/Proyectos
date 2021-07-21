package logico;

import java.util.Date;

public abstract class Component {

	protected String serial;
	protected int available;
	protected float price;
	protected String brand;
	protected int min_amount;
	protected int max_amount;
	
	public Component(String serial, int available, float price, String brand, int min_amount, int max_amount) {
		super();
		this.serial = serial;
		this.available = available;
		this.price = price;
		this.brand = brand;
		this.min_amount = min_amount;
		this.max_amount = max_amount;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
		if(this.available < min_amount) {
			generate_order();
		}
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(int min_amount) {
		this.min_amount = min_amount;
	}

	public int getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}
	
	private void generate_order() {
		/* Automatically generates a purchase order if available
		 * amount of objects drops below the minimum (see setAvailable above).
		 * private because it must only be called by this class automatically. */
		
		// Work in progress.
		/* Missing: order's code (supposed to be automatically generated). 
		 * 			Setting a Distributor.*/
		
		String code = null;
		Date date = new Date();
		Distributor distributor = null;
		PurchaseOrder order = new PurchaseOrder(code, date, distributor, this, this.max_amount);
		Store.getInstance().addOrder(order);
	}
	
	
}
