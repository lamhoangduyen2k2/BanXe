package vn.models;

import java.sql.Date;

public class StoreLevel {
	private int _id;
	private String _name;
	private int minPoint;
	private double discount;
	private boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;
	
	public StoreLevel(int _id, String _name, int minPoint, double discount, boolean isDeleted, Date createdAt,
			Date updatedAt) {
		super();
		this._id = _id;
		this._name = _name;
		this.minPoint = minPoint;
		this.discount = discount;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public int getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(int minPoint) {
		this.minPoint = minPoint;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isDeleted() {
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
