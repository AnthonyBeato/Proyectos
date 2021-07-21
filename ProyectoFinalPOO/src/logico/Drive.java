package logico;

public class Drive extends Component {

	private String model;
	private String connector;
	private float storage;
	
	public Drive(String serial, int available, float price, String brand, int min_amount, int max_amount, String model,
			String connector, float storage) {
		super(serial, available, price, brand, min_amount, max_amount);
		this.model = model;
		this.connector = connector;
		this.storage = storage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public float getStorage() {
		return storage;
	}

	public void setStorage(float storage) {
		this.storage = storage;
	}
	
	
	
}
