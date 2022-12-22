package com.model;

public class Client {

	private int id;
	private String clientname;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the clientname
	 */
	public String getClientname() {
		return clientname;
	}
	/**
	 * @param id
	 * @param clientname
	 * @param category
	 * @param location
	 * @param email
	 * @param password
	 * @param confirmpassword
	 */
	public Client(int id, String clientname, String category, String location, String email, String password,
			String confirmpassword) {
		super();
		this.id = id;
		this.clientname = clientname;
		this.category = category;
		this.location = location;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	/**
	 * 
	 */
	public Client() {
		super();
	}
	/**
	 * @param clientname the clientname to set
	 */
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", clientname=" + clientname + ", category=" + category + ", location=" + location
				+ ", email=" + email + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmpassword
	 */
	public String getConfirmpassword() {
		return confirmpassword;
	}
	/**
	 * @param confirmpassword the confirmpassword to set
	 */
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	private String category;
	private String location;
	private String email;
	private String password;
	private String confirmpassword;
	
}
