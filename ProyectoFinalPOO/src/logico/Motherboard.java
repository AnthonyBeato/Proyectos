package logico;

import java.util.ArrayList;

public class Motherboard extends Component {

	private String model;
	private String socket;
	private String compatible_RAM;
	private ArrayList<String> compatible_hdds;
	
	public Motherboard(String serial, int available, float price, String brand, int min_amount, int max_amount,
			String model, String socket, String compatible_RAM, ArrayList<String> compatible_hdds) {
		super(serial, available, price, brand, min_amount, max_amount);
		this.model = model;
		this.socket = socket;
		this.compatible_RAM = compatible_RAM;
		this.compatible_hdds = compatible_hdds;
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

	public String getCompatible_RAM() {
		return compatible_RAM;
	}

	public void setCompatible_RAM(String compatible_RAM) {
		this.compatible_RAM = compatible_RAM;
	}

	public ArrayList<String> getCompatible_hdds() {
		return compatible_hdds;
	}

	public void setCompatible_hdds(ArrayList<String> compatible_hdds) {
		this.compatible_hdds = compatible_hdds;
	}
	
	

}
