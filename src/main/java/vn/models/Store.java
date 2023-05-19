package vn.models;

import java.sql.Date;

public class Store {
	private int _id;
	private String _name;
	private String bio;
	private String slug;
	private int ownerId;
	private boolean isActive;
	private boolean isOpen;
	private String avatar;
	private String cover;
	private int commissionId;
	private int point;
	private int rating;
	private double e_wallet;
	private Date createdAt;
	private Date updatedAt;
	private _User _user;
	private Commission commission;
	
	public Store(int _id, String _name, String bio, String slug, int ownerId, boolean isActive, boolean isOpen,
			String avatar, String cover, int commissionId, int point, int rating,
			double e_wallet, Date createdAt, Date updatedAt, _User _user, Commission commission) {
		super();
		this._id = _id;
		this._name = _name;
		this.bio = bio;
		this.slug = slug;
		this.ownerId = ownerId;
		this.isActive = isActive;
		this.isOpen = isOpen;
		this.avatar = avatar;
		this.cover = cover;
		this.commissionId = commissionId;
		this.point = point;
		this.rating = rating;
		this.e_wallet = e_wallet;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this._user = _user;
		this.commission = commission;
	}

	public Store() {
		super();
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public boolean getisActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getisOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
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

	public int getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	public _User get_user() {
		return _user;
	}

	public void set_user(_User _user) {
		this._user = _user;
	}

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}
	
}
