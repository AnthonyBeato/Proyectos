package logico;

public class Seller extends User {
	
	private float sold_amount;		// Total sold amount in $.
	private float commission;		// commission percentage (%)

	public Seller(String id, String username, String password, String name, float sold_amount, float commission) {
		super(id, username, password, name);
		this.sold_amount = sold_amount;
		this.commission = commission;
	}

	public float getSold_amount() {
		return sold_amount;
	}

	public void setSold_amount(float sold_amount) {
		this.sold_amount = sold_amount;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

}
