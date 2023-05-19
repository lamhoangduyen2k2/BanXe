package vn.models;

import java.sql.Date;

public class _Order {
	private int _id;
	private int userId;
	private int storeId;
	private int deliveryId;
	private int commissionId;
	private String address;
	private String phone;
	private String status;
	private boolean isPaidBefore;
	private int amountFromUser;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGD;
	private Date createdAt;
	private Date updatedAt;
	private _User _user;
	private Store store;
	private Delivery delivery;
	private Commission commission;
	
	public _Order(int _id, int userId, int storeId, int deliveryId, int commissionId, String address, String phone,
			String status, boolean isPaidBefore, int amountFromUser, int amountFromStore, int amountToStore,
			int amountToGD, Date createdAt, Date updatedAt, _User _user, Store store, Delivery delivery,
			Commission commission) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.commissionId = commissionId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this._user = _user;
		this.store = store;
		this.delivery = delivery;
		this.commission = commission;
	}
	
	
	public _Order() {
		super();
	}


	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getCommissionId() {
		return commissionId;
	}
	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getisPaidBefore() {
		return isPaidBefore;
	}
	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}
	public int getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(int amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public int getAmountFromStore() {
		return amountFromStore;
	}
	public void setAmountFromStore(int amountFromStore) {
		this.amountFromStore = amountFromStore;
	}
	public int getAmountToStore() {
		return amountToStore;
	}
	public void setAmountToStore(int amountToStore) {
		this.amountToStore = amountToStore;
	}
	public int getAmountToGD() {
		return amountToGD;
	}
	public void setAmountToGD(int amountToGD) {
		this.amountToGD = amountToGD;
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
	public _User get_user() {
		return _user;
	}
	public void set_user(_User _user) {
		this._user = _user;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Commission getCommission() {
		return commission;
	}
	public void setCommission(Commission commission) {
		this.commission = commission;
	}
	
}
