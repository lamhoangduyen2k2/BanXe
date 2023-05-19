package vn.dao;

import java.util.List;

import vn.models.Store;

public interface StoreDAO {
	List<Store> findAllStore();
	Store findStoreByID(int _id);
	void insert(Store store);
	void edit(Store store);
	void delete(int id);
}
