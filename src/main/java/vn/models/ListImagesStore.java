package vn.models;

public class ListImagesStore {
	private int _id;
	private String featured_image;
	private Store store;
	
	public ListImagesStore(int _id, String featured_image, Store store) {
		super();
		this._id = _id;
		this.featured_image = featured_image;
		this.store = store;
	}

	public ListImagesStore() {
		super();
	}


	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getFeatured_image() {
		return featured_image;
	}

	public void setFeatured_image(String featured_image) {
		this.featured_image = featured_image;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	
}
