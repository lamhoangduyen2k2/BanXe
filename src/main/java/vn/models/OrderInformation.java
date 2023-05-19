package vn.models;

import java.sql.Date;

public class OrderInformation {

	private int _id;
	private String lastname;
	private String firstname;
	private String address;
	private int phone;
	private String name;
	private double price;
	private int amountFromUser;
	private boolean isPaid;
	private Date createdAt;
	private String status;
	public OrderInformation() {
		super();
	}
	public OrderInformation(int _id, String lastname, String firstname, String address, int phone, String name,
			double price, int amountFromUser, boolean isPaid, Date createdAt, String status) {
		super();
		this._id = _id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.price = price;
		this.amountFromUser = amountFromUser;
		this.isPaid = isPaid;
		this.createdAt = createdAt;
		this.status = status;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(int amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
