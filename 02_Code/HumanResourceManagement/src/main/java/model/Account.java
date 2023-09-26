package model;

public class Account {
	private int id;
	private String userName;
	private boolean active;
	private String password;
	private String userRole;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Account() {
		super();
	}
	public Account(int id, String userName, boolean active, String password, String userRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.active = active;
		this.password = password;
		this.userRole = userRole;
	}	
}
