package logico;

public class Customer {
	
	private String id;
	private String name;
	private float credit;
	
	public Customer(String id, String name, float credit) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
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

}
