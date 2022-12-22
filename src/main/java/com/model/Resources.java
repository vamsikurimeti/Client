package com.model;

public class Resources {
	
	private int id;
	private String corporateemail;
    private String name;
    private String status;
    private String skills;
    /**
	 * 
	 */
	public Resources() {
		super();
	}
	/**
	 * @param id
	 * @param corporateemail
	 * @param name
	 * @param status
	 * @param skills
	 * @param location
	 */
	public Resources(int id, String corporateemail, String name, String status, String skills, String location) {
		super();
		this.id = id;
		this.corporateemail = corporateemail;
		this.name = name;
		this.status = status;
		this.skills = skills;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", corporateemail=" + corporateemail + ", name=" + name + ", status=" + status
				+ ", skills=" + skills + ", location=" + location + "]";
	}
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
	 * @return the corporateemail
	 */
	public String getCorporateemail() {
		return corporateemail;
	}
	/**
	 * @param corporateemail the corporateemail to set
	 */
	public void setCorporateemail(String corporateemail) {
		this.corporateemail = corporateemail;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
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
	private String location;
}
