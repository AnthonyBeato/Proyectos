package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<User> users;
	private ArrayList<Component> components;
	private ArrayList<Invoice> invoices;
	private ArrayList<Customer> customers;
	private ArrayList<Distributor> distributors;
	private ArrayList<Combo> combos;
	private ArrayList<PurchaseOrder> orders;
	public static Store store = null;
	public static User loggedUser;
	
	private Store() {
		super();
		this.users = new ArrayList<User>();
		this.components = new ArrayList<Component>();
		this.invoices = new ArrayList<Invoice>();
		this.customers = new ArrayList<Customer>();
		this.distributors = new ArrayList<Distributor>();
		this.combos = new ArrayList<Combo>();
		this.orders = new ArrayList<PurchaseOrder>();
	}
	
	public static Store getInstance() {
		if(store == null) {
			store = new Store();
		}
		
		return store;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Distributor> getDistributors() {
		return distributors;
	}

	public void setDistributors(ArrayList<Distributor> distributors) {
		this.distributors = distributors;
	}

	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public ArrayList<PurchaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<PurchaseOrder> orders) {
		this.orders = orders;
	}

	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		Store.loggedUser = loggedUser;
	}
	
	public boolean validate(String username, String password) {
		/* Given a username and a password, checks if they match the user's.
		 * Returns true if they do; false if they don't. 
		 * If true, sets loggedUser to the current user.*/
		
		boolean matches = false;
		for (User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				loggedUser = user;
				matches = true;
			}
		}
		return matches;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void addDistributor(Distributor distributor) {
		distributors.add(distributor);
	}
	
	public void addCombo(Combo combo) {
		combos.add(combo);
	}
	
	public void addOrder(PurchaseOrder order) {
		orders.add(order);
	}
	
	public static Store getStore() {
		return store;
	}

	public static void setStore(Store store) { 
		Store.store = store;
	}
	
	
}
