package logico;

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
	
	
}
