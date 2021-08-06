package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
	
	public User search_user(String id) {
		User searched = null;
		for (User user : users) {
			if(user.getId().equalsIgnoreCase(id)) {
				searched = user;
			}
		}
		return searched;
	}
	
	public Customer search_customer(String id) {
		Customer searched = null;
		for (Customer customer : customers) {
			if(customer.getId().equalsIgnoreCase(id)) {
				searched = customer;
			}
		}
		return searched;
	}

	public void deleteCustomer(Customer selected_customer) {
		customers.remove(selected_customer);
	}
	
	public void modificarCustomer(Customer selected) {
		int index = searchIndexOfCustomersByCode(selected.getId());
		customers.set(index, selected);
		
	}

	private int searchIndexOfCustomersByCode(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < customers.size()) {
			if (customers.get(i).getId().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		
		return aux;
	}

	public void modifyUser(int index, User selected) {
		users.set(index, selected);
		
	}

	public void deleteUser(User selected_user) {
		users.remove(selected_user);
		
	}
	
	public void deleteComponent(Component selected_components) {
		components.remove(selected_components);
		
	}

	public void mod_components(int index, Component selected) {
		components.set(index, selected);
	}

	public Component search_component(String code) {
		Component searched = null;
		for (Component component : components) {
			if(component.getSerial().equalsIgnoreCase(code)) {
				searched = component;
			}
		}
		return searched; 
	}

	public Invoice search_invoice(String idInvoice) {
		Invoice searched = null;
		for (Invoice invoice : invoices) {
			if(invoice.getCode().equalsIgnoreCase(idInvoice)) {
				searched = invoice;
			}
		}
		return searched; 
	} 
	
	public String autogenerateId() {
	      Random rand = new Random();
	      int upperbound = 100000;
	      int int_random = rand.nextInt(upperbound); 
	      String resultado = String.valueOf(int_random);
		return resultado;
	}

	public PurchaseOrder search_orderPurchase(String idOrder) {
		PurchaseOrder searched = null;
		for (PurchaseOrder order : orders) {
			if(order.getCode().equalsIgnoreCase(idOrder)) {
				searched = order;
			}
		}
		return searched; 
	}
	
	public void crearOrdenCompra() {
		
		for (Component component : components) {
			@SuppressWarnings("unused")
			Component componenteAOrdernar = null;
			if(component.getAvailable() <= component.getMin_amount()) {
				if(ordenProductoExistente(component) == false) {
					componenteAOrdernar = component;
					PurchaseOrder aux = new PurchaseOrder(autogenerateId(), new Date(), componenteAOrdernar, componenteAOrdernar.max_amount);
					addOrder(aux);
				}
			}
		}
	}

	private boolean ordenProductoExistente(Component component) {
		boolean existe = false;
		
		for (PurchaseOrder order : orders) {
			if (order.getComponent().equals(component)) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}

	public void efectuarOrdenDeCompra(PurchaseOrder selected_order) {
		selected_order.setDone(true);
		String idComponente = selected_order.getComponent().getSerial();
		
		Component aux = search_component(idComponente);
		aux.setAvailable(aux.max_amount);
	}

	public Combo search_combo(String code) {
		Combo searched = null;
		for (Combo combo : combos) {
			if(combo.getCode().equalsIgnoreCase(code)) {
				searched = combo;
			}
		}
		return searched;
	}

	public void deleteCombo(Combo selected_combo) {
		for (Combo combo : combos) {
			if(combo.equals(selected_combo)) {
				combos.remove(combo);
			}
		}
		
	}
}
