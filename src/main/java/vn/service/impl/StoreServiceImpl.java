package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class StoreServiceImpl implements StoreService{
	StoreDAO modelDao = new StoreDaoImpl();

	@Override
	public List<Store> findAllStore() {
		return modelDao.findAllStore();
	}
	
	@Override
	public Store findStoreByID(int _id) {
		return modelDao.findStoreByID(_id);
	}

	@Override
	public void insert(Store store) {
		modelDao.insert(store);
	}

	@Override
	public void edit(Store store) {
		modelDao.edit(store);
	}

	@Override
	public void delete(int id) {
		modelDao.delete(id);
	}
}
