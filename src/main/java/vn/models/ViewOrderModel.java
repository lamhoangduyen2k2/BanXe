package vn.models;

public class ViewOrderModel {

	private int _id;
	private String lastname;
	private String firstname;
	private String status;
	public ViewOrderModel() {
		super();
	}
	public ViewOrderModel(int _id, String lastname, String firstname, String status) {
		super();
		this._id = _id;
		this.lastname = lastname;
		this.firstname = firstname;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
