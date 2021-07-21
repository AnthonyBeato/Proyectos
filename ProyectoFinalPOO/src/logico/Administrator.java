package logico;

public class Administrator extends User {
	
	private int years;		// Years of experience.

	public Administrator(String id, String username, String password, String name, int years) {
		super(id, username, password, name);
		this.years = years;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

}
