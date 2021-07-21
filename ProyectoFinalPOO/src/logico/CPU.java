package logico;

public class CPU extends Component {

	private String model;
	private String socket;
	private float speed;
	
	public CPU(String serial, int available, float price, String brand, int min_amount, int max_amount, String model,
			String socket, float speed) {
		super(serial, available, price, brand, min_amount, max_amount);
		this.model = model;
		this.socket = socket;
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}
