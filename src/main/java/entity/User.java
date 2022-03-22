package entity;

public class User {
	
	private String userName;
	private String userPassword;
	
	public User() {
	}
	
	public User(String name, String pass) {
		this.userName = name;
		this.userPassword = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
