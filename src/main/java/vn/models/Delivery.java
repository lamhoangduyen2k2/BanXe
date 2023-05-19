package vn.models;

import java.sql.Date;

public class Delivery {
	private int _id;
	private String name;
	private String description;
	private double price;
	private boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;
	public Delivery(int _id, String name, String description, double price, boolean isDeleted, Date createdAt,
			Date updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public int get_id() {
		return _id;
	}
	public Delivery() {
		super();
	}


	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getisDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
