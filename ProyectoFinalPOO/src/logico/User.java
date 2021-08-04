package logico;

import java.io.Serializable;

public abstract class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String username;
	protected String password;
	protected String name;		//Person's name and surname
	public static int counter = 100;
	
	public User(String id, String username, String password, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		counter++;
	}
	
	public String getId() {
		return id; 
	}
	
	public void setId(String id) {
		this.id = id; 
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	

}
