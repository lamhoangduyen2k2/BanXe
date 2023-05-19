package vn.models;

public class Store_Staff {
	private int storeId;
	private int staffId;
	private Store store;
	private _User _user;
	
	public Store_Staff(int storeId, int staffId, Store store, _User _user) {
		super();
		this.storeId = storeId;
		this.staffId = staffId;
		this.store = store;
		this._user = _user;
	}
	

	public Store_Staff() {
		super();
	}


	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public _User get_user() {
		return _user;
	}

	public void set_user(_User _user) {
		this._user = _user;
	}
	
}
