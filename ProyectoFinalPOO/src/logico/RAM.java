package logico;

public class RAM extends Component {

	private String type;
	private float capacity;
	
	public RAM(String serial, int available, float price, String brand, int min_amount, int max_amount, String type,
			float capacity) {
		super(serial, available, price, brand, min_amount, max_amount);
		this.type = type;
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	
}
