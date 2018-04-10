package domain;

public class UserModel {
	public static int ADMIN = 5;
	public static int PREMIUM = 3;
	public static int REGULAR = 0;
	
	public UserModel(String username, String password, String email, int accessLevel) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.accessLevel = accessLevel;
	}
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private int accessLevel;
	
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
