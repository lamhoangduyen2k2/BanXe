package vn.models;

import java.sql.Date;

public class _User{

	private int _id;
	private String firstname;
	private String lastname;
	private String slug;
	private String id_card;
	private String email;
	private String phone;
	private boolean isEmalActive;
	private boolean isPhoneActive;
	private String salt;
	private String hashed_password;
	private String _role;
	private String addresses;
	private String avatar;
	private String cover;
	private int point;
	private double e_wallet;
	private Date createdAt;
	private Date updatedAt;
	
	public _User() {
		super();
	}

	public _User(int _id, String firstname, String lastname, String slug, String id_card, String email, String phone,
			boolean isEmalActive, boolean isPhoneActive, String salt, String hashed_password, String _role,
			String addresses, String avatar, String cover, int point, double e_wallet, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.slug = slug;
		this.id_card = id_card;
		this.email = email;
		this.phone = phone;
		this.isEmalActive = isEmalActive;
		this.isPhoneActive = isPhoneActive;
		this.salt = salt;
		this.hashed_password = hashed_password;
		this._role = _role;
		this.addresses = addresses;
		this.avatar = avatar;
		this.cover = cover;
		this.point = point;
		this.e_wallet = e_wallet;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	

	public _User(int _id, String firstname, String lastname, String id_card, String email, String phone,
			String hashed_password,
			String addresses, String avatar, String cover, int point, double e_wallet) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.id_card = id_card;
		this.email = email;
		this.phone = phone;
		this.hashed_password = hashed_password;
		this.addresses = addresses;
		this.avatar = avatar;
		this.cover = cover;
		this.point = point;
		this.e_wallet = e_wallet;
	}

	
	
	public _User(String email, String hashed_password) {
		super();
		this.email = email;
		this.hashed_password = hashed_password;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getisEmalActive() {
		return isEmalActive;
	}

	public void setEmalActive(boolean isEmalActive) {
		this.isEmalActive = isEmalActive;
	}

	public boolean getisPhoneActive() {
		return isPhoneActive;
	}

	public void setPhoneActive(boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashed_password() {
		return hashed_password;
	}

	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}

	public String get_role() {
		return _role;
	}

	public void set_role(String _role) {
		this._role = _role;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public double getE_wallet() {
		return e_wallet;
	}

	public void setE_wallet(double e_wallet) {
		this.e_wallet = e_wallet;
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
