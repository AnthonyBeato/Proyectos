package logico;

import java.util.Date;

public class PurchaseOrder {
	
	private String code;		// Identification number.
	private Date date;
	private Distributor distributor;
	private Component component;
	private int amount;			// Amount of objects ordered, e.g. 10 HDDs.
	
	private boolean done;		/* Marks the status of the order. If done
	 								is true, it means it has been approved, 
	 								and if it's false, it is yet to be approved.
	 								Approving an order is the admin's job.*/

	public PurchaseOrder(String code, Date date, Distributor distributor, Component component, int amount) {
		super();
		this.code = code;
		this.date = date;
		this.distributor = distributor;
		this.component = component;
		this.amount = amount;
		this.done = false;		// done starts false by default.
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

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	

}
